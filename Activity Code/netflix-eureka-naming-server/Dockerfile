FROM fabric8/java-alpine-openjdk8-jdk
ADD target/*.jar app.jar
RUN touch /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8761