FROM  amazoncorretto:17-alpine3.17-jdk
MAINTAINER jhajayra
COPY target/portfolio-0.0.1-SNAPSHOT.jar back-app.jar
ENTRYPOINT ["JAVA","-jar","/back-app.jar"]