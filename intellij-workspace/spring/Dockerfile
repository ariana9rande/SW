FROM openjdk:17-jdk
LABEL authors="admin"
ARG JAR_FILE=myBoard.jar
ADD ${JAR_FILE} myBoard.jar
ENTRYPOINT ["java", "-jar", "/myBoard.jar"]
