# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
MAINTAINER Keith Priddle<k.priddle66@gmail.com>

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=/target/parser-financial-app-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} parser-financial-app-0.0.1-SNAPSHOT.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","parser-financial-app-0.0.1-SNAPSHOT.jar"]





# FROM openjdk:8-jdk-alpine AS builder
# WORKDIR target/dependency
# ARG APPJAR=target/*.jar
# COPY ${APPJAR} app.jar
# RUN jar -xf ./app.jar

# FROM openjdk:8-jre-alpine
# VOLUME /tmp
# ARG DEPENDENCY=target/dependency
# COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
# COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
# ENTRYPOINT ["java","-cp","app:app/lib/*","com.moderncloudtech.financial"]