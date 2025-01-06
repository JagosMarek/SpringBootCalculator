FROM openjdk:17-jdk-slim

WORKDIR /app

COPY pom.xml mvnw ./
COPY .mvn .mvn

RUN ./mvnw dependency:go-offline -B

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/SpringCalculator-1.0-SNAPSHOT.jar"]

