FROM openjdk:21
WORKDIR /app
COPY /target/courseWorkServer-0.0.1-SNAPSHOT.jar /app/coursework.jar
ENTRYPOINT ["java", "-jar", "coursework.jar"]