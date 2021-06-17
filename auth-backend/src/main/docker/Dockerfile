FROM openjdk:11-jdk-slim-buster

ENV TZ=Europe/Moscow

ARG JAR_FILE=/target/app-1.jar

COPY ${JAR_FILE} app.jar

CMD java $JAVA_OPTS -jar app.jar