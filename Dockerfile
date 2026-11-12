# Stage 1: Build the Maven project
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

# Stage 2: Create the final image
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/shop-1.0-SNAPSHOT.jar app.jar

CMD ["sh", "-c", "echo 'Shopping Cart JAR packaged successfully' && ls -lh app.jar"]