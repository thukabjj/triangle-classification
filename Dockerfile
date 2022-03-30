FROM gradle:jdk17-alpine

RUN mkdir -p /workspace
COPY . /workspace

WORKDIR /workspace

RUN gradle build --no-daemon
COPY ./build/libs/classification-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]