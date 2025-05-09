FROM openjdk:21-jdk
COPY target/springboot-greendogdelivery-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]