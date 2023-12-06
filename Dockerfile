FROM openjdk:17
ADD target/health.jar health.jar

ENTRYPOINT ["java", "-jar","health.jar"]
EXPOSE 8080