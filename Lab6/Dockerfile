FROM maven:3.6.3-jdk-11-slim AS MAVEN_BUILD

COPY . /build/

WORKDIR /build/
RUN mvn clean package

FROM openjdk:10

WORKDIR /app/

COPY --from=MAVEN_BUILD /build/target/Lab6-1.0-SNAPSHOT.jar /app/
CMD ["java","-jar","Lab6-1.0-SNAPSHOT.jar"]

