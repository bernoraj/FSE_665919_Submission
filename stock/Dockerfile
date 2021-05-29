#
# STOCK JAR PACKAGE STAGE
#
FROM openjdk
ADD target/SpringMSStock.jar SpringMSStock.jar
ENV JAVA_OPTS=""\
    DB_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /SpringMSStock.jar" ]

