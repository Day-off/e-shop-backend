FROM eclipse-temurin:17-jre-alpine
ADD target/ITI0302-backend-0.0.1-SNAPSHOT.jar /app/app.jar
CMD java -Dspring.config.location=classpath:/application.yml,file:/app/application.yml -jar /app/app.jar