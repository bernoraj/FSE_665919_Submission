#
# COMPANY JAR PACKAGE STAGE
#
FROM openjdk
ADD target/SpringMSCompany.jar SpringMSCompany.jar
ENV JAVA_OPTS="";
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /SpringMSCompany.jar" ]

