# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container
COPY build/libs/your-app-name.jar /app/your-app-name.jar

# Run the application
CMD ["java", "-jar", "your-app-name.jar"]
