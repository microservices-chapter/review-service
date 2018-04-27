FROM java:8-jre
MAINTAINER Ben Edgar

ADD ./build/libs/review-service-1.0-SNAPSHOT.jar /service/
CMD ["java", "-Xmx200m", "-jar", "/service/review-service-1.0-SNAPSHOT.jar"]

EXPOSE 8082
