FROM adoptopenjdk/openjdk11:alpine-jre
ADD out/artifacts/patient_management_jar/patient-management.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]