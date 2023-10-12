FROM openjdk:17-jdk
LABEL authors="admin"
ARG JAR_FILE=target/main-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} main.jar
ENTRYPOINT ["java", "-jar", "/main.jar"]