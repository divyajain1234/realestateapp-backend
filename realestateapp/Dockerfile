FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# Make the Maven wrapper executable
RUN chmod +x mvnw

# Build the Spring Boot jar
RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/realestateapp-0.0.1-SNAPSHOT.jar"]
