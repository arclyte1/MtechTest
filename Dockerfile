FROM gradle:8.5.0-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
RUN gradle build
RUN mv build/libs/test-0.0.1-SNAPSHOT.jar build/libs/app.jar

FROM openjdk:17
EXPOSE 8080
COPY --from=build /home/gradle/build/libs/app.jar /app/
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-jar", "/app/app.jar"]