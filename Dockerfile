FROM eclipse-temurin:19-jdk-alpine
WORKDIR /app
ADD --chown=gradle:gradle /app/arktos-joiner-public-0.0.1.jar /app
RUN ./gradlew build --stacktrace