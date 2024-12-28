FROM maven:3.9.9-openjdk-21 AS build
WORKDIR /app
COPY target/Clinic-0.0.1-SNAPSHOT.jar Clinic-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/Clinic-0.0.1-SNAPSHOT.jar"]
