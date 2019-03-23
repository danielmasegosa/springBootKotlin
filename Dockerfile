FROM openjdk:8u151-alpine3.7
VOLUME /tmp
ADD /build/libs/spring-boot-kotlin-0.0.1-SNAPSHOT.jar service.jar
ENTRYPOINT exec java -jar /service.jar