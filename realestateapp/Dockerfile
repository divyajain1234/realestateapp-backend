# Stage 1: Build the Spring Boot jar with Maven
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom and source
COPY pom.xml .
COPY src ./src

# Build jar (tests skip)
RUN mvn clean package -DskipTests

# Stage 2: Run the jar on a lighter JDK image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/realestateapp-0.0.1-SNAPSHOT.jar app.jar

# Run the app
CMD ["java", "-jar", "app.jar"]
