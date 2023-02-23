FROM eclipse-temurin:19-jdk-alpine
WORKDIR /app
ADD --chown=gradle:gradle /build/libs/arktos-joiner-public-0.0.1.jar /app
CMD ["java","-jar","arktos-joiner-public-0.0.1.jar"]