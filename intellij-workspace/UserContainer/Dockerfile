FROM openjdk:17-jdk
LABEL authors="admin"
ARG JAR_FILE="./usercontainer-0.0.1-SNAPSHOT.jar"
ADD ${JAR_FILE} user-container.jar

ENTRYPOINT ["java", "-jar", "user-container.jar"]