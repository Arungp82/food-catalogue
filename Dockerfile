FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
WORKDIR /opt
COPY target/*.jar /opt/food-catalogue-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar food-catalogue-service.jar