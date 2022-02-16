FROM openjdk:11-jre-slim
EXPOSE 8080
COPY target/kafkaproducerexample-*.jar app.jar
ENTRYPOINT ["java","-jar","-Duser.timezone=America/Sao_Paulo", "-Duser.country=BR","-Duser.language=pt","-Dspring.profiles.active=docker","/app.jar"]
