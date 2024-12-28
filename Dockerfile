FROM openjdk-21 AS build
WORKDIR /app
COPY target/Clinic-0.0.1-SNAPSHOT.jar /app/clinic.jar
EXPOSE 8080
CMD ["java", "-jar", "/clinic.jar"]
