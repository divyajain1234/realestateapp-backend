# 1st stage: build the jar using Maven image
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# copy pom.xml and src
COPY pom.xml .
COPY src ./src

# build jar
RUN mvn clean package -DskipTests

# 2nd stage: run only the jar on a light JDK image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# copy jar from builder stage
COPY --from=build /app/target/realestateapp-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
