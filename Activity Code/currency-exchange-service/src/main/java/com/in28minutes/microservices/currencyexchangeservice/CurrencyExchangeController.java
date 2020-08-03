package com.in28minutes.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue
		(@PathVariable String from, @PathVariable String to){
		
		ExchangeValue exchangeValue = 
				repository.findByFromAndTo(from, to);
		
		exchangeValue.setPort(
				Integer.parseInt(environment.getProperty("local.server.port")));
		
		logger.info("{}", exchangeValue);
		
		return exchangeValue;
	}
	@GetMapping("/getConversionFactor/from/{from}")
    public ExchangeValue getConvertFactor( @PathVariable String from)
    {
		ExchangeValue cnv=repository.findByFrom(from);    
        cnv.setPort(
                Integer.parseInt(environment.getProperty("local.server.port")));
        logger.info("{}",cnv);
                return cnv;
    }
	@PostMapping("/addConversionFactor")
    public ExchangeValue addConvertFactor( @RequestBody ExchangeValue cnvt) {
     return repository.save(cnvt);
    }
	
	@PutMapping("/updateConversionFactor/{id}")
    public ResponseEntity<ExchangeValue> updateConvertFactor(
    @PathVariable(value = "id") int id,
     @RequestBody ExchangeValue cnvu){
		ExchangeValue cnv= repository.findById(id) ;
		cnv.setFrom(cnvu.getFrom());
		cnv.setConversionMultiple(cnvu.getConversionMultiple());
         ExchangeValue cnv3 = repository.save(cnv);
        return ResponseEntity.ok(cnv3);
        
	}

}
