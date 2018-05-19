# Start with a reasonably modest linux+java8+maven image
FROM maven:3.5.3-jdk-8-alpine

# Add our name as the maintainer of *this* image
MAINTAINER Scott McCrory <scott@mccrory.us>

# Copy our whole project into a working directory
COPY . /usr/src/app
WORKDIR /usr/src/app

# Update the images' libraries with any latest security patches, etc.
RUN apk update
RUN apk upgrade

# Execute "mvn spring-boot:run" to properly start up our Spring Boot app.
#   Note that this helps to overcome a limitations with Thymeleaf directories.
#   A Tomcat container running on port 8080 will be automatically started
CMD ["mvn", "spring-boot:run"]

# Finally, expose Tomcat's port to the host, but don't prescribe what IT should map to.
#    It's best to allow the container manager to decide which ports to use.
EXPOSE 8080:8080