
# Officail OpenJDK 23 image
FROM eclipse-temurin:23-jdk

# Set working directory
WORKDIR /app

# Copy everything to container
COPY . .

# Give permission to mvnw
RUN chmod +x mvnw

# Build the application
RUN  ./mvnw clean package -DskipTests

# Expose Render port
EXPOSE 8080

# Run the jar file
CMD ["sh","-c","java -jar target/*.jar"]