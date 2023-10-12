FROM openjdk:17-jdk
LABEL authors="admin"
ARG JAR_FILE=target/board-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} board-board.jar

ENTRYPOINT ["java", "-jar", "board-board.jar"]