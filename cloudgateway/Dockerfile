#
# GATEWAY JAR PACKAGE STAGE
#
FROM openjdk
ADD target/SpringGatewayServer.jar SpringGatewayServer.jar
ENV JAVA_OPTS="";
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /SpringGatewayServer.jar" ]

