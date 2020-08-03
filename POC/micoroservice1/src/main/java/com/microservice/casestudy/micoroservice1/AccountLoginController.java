package com.microservice.casestudy.micoroservice1;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.lang3.StringUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AccountLoginController {
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	public static final long JWT_TOKEN_VALIDITY1 = 8 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.grant}")
	private String grant;
	
	@Value("${jwt.apikey}")
	private String apikey;

	@GetMapping("/generateToken")
	private GenerateToken doGenerateToken(Map<String, Object> claims, String subject) {
		GenerateToken generateToken =new GenerateToken();
		 String url = "https://iam.cloud.ibm.com/identity/token"; 

		generateToken.setServiceToken( Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact());
		
		generateToken.setTransctionToken(Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY1 * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact());
		
		MultiValueMap<String,Object> uriVariables=new LinkedMultiValueMap<>();
        uriVariables.add("grant_type", grant);
        uriVariables.add("apikey", apikey);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> entity = new HttpEntity<>(uriVariables, headers);
        Object token = restTemplate.exchange(url, HttpMethod.POST, entity, Object.class);
       // System.out.println(token.toString());
        String str=(String)token.toString();                    
        String s = StringUtils.substringBetween(str, "=", ","); 
        System.out.println(s);
       
        generateToken.setUserToken(s);
        
        return generateToken;		
	}
	
}
