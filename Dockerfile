FROM openjdk:8
ADD target/test-app.war test-app.war
EXPOSE 8089
ENTRYPOINT ["java","-jar","test-app.war"]