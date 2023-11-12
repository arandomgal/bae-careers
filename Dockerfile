FROM amazoncorretto:17.0.9-alpine
WORKDIR /
ADD target/bae-careers-1.0.3-SNAPSHOT.jar //
ENTRYPOINT [ "java", "-jar", "/bae-careers-1.0.3-SNAPSHOT.jar"]