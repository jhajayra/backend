FROM amazoncorretto:17-al2-jdk
MAINTAINER jhajayra
COPY target/portfolio-0.0.1-SNAPSHOT.jar back-app.jar
ENTRYPOINT ["JAVA","-jar","/back-app.jar"]