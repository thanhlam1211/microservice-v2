FROM openjdk:17

#Information around who maintains the image
MAINTAINER lambui

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]