FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/getir-case.jar getir-case.jar
ENTRYPOINT ["java","-jar","/getir-case.jar"]