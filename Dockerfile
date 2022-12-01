FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/mvnuk/rizeniinformatikydemo.git

FROM maven:3.8.6-eclipse-temurin-17-alpine as build
WORKDIR /app
COPY --from=clone /app/rizeniinformatikydemo /app
RUN mvn install

FROM openjdk:17
EXPOSE 8080
WORKDIR /app
COPY --from=build /app/target/spring-boot-docker.jar /app
CMD ["java", "-jar", "spring-boot-docker.jar"]