# Use the base image
FROM ghcr.io/railwayapp/nixpacks:ubuntu-1716249803

# Set the working directory
WORKDIR /app

# Copy project files into the container
COPY . /app/

# Make Maven wrapper executable
RUN chmod +x /app/mvnw

# Run Maven build
RUN ./mvnw clean install

# Start the application
CMD ["java", "-jar", "target/*.jar"]
