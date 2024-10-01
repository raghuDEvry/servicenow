# Use the official OpenJDK image
FROM openjdk:17-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Add the application's jar to the container
COPY target/spring-boot-app.jar /app/spring-boot-app.jar

# Expose port 8080
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/spring-boot-app.jar"]
