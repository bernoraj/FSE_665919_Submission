#
# JAR PACKAGE STAGE
#
FROM openjdk
ADD target/KafkaServer.jar KafkaServer.jar
ENTRYPOINT ["java","-jar","KafkaServer.jar"]