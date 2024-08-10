# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/com.example.practiceKtor-0.0.1.jar /app/app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
