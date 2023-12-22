FROM openjdk:17-jdk-alpine
RUN mkdir /app
WORKDIR /app
COPY target/*.jar /app/ms-eureka.jar
CMD ["java", "-jar", "/app/ms-eureka.jar"]