# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="gekylin@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8871

# The application's jar file
ARG JAR_FILE=target/spring-cloud-consumer-1.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} spring-cloud-consumer.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-cloud-consumer.jar"]