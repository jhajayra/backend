FROM amazoncorretto:18-alpine-jdk
MAINTAINER jhajayra
COPY target/portfolio-0.0.1-SNAPSHOT.jar backjhaja-app.jar
ENTRYPOINT ["JAVA", "-jar","/backjhaja-app.jar"]