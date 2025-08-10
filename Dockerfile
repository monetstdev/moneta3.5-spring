# Multi-stage build
# 1. Build Stage
FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

# 2. Run Stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/moneta-0.0.1-SNAPSHOT.jar /app/moneta.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "moneta.jar"]
