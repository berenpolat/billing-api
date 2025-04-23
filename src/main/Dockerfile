# ---- Build stage ----
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# ---- Runtime stage ----
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/billing-api-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

HEALTHCHECK CMD curl --fail http://localhost:10000/health || exit 1
