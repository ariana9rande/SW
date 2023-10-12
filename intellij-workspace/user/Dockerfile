FROM openjdk:17-jdk
LABEL authors="admin"
ARG JAR_FILE=target/user-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} board-user.jar

ENTRYPOINT ["java", "-jar", "board-user.jar"]