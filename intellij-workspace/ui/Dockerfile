FROM ubuntu:latest
LABEL authors="admin"
ARG JAR_FILE=target/ui-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} board-ui.jar

ENTRYPOINT ["java", "-jar", "board-ui.jar"]