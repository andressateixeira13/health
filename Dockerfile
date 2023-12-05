FROM openjdk:17
ADD target/Health.jar Health.jar
ENTRYPOINT ["java", "-jar","Health.jar"]
EXPOSE 8080