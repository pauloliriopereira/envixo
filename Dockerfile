FROM maven:3.6.3-jdk-13 AS build
WORKDIR /home/app/
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn clean package -DskipTests

FROM openjdk:13-jdk-oracle

COPY --from=build /home/app/target/envixo.war /usr/local/lib/envixo.war
ENTRYPOINT java -jar /usr/local/lib/envixo.war
EXPOSE 8080
