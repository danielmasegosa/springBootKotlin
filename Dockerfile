FROM openjdk:8u151-alpine3.7
VOLUME /tmp
ADD /build/libs/spring-boot-kotlin.jar service.jar
ENTRYPOINT exec java -jar /service.jar