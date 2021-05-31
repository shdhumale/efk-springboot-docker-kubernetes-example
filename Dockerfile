FROM java:8-jdk-alpine
COPY ./target/efk-springboot-docker-kubernetes-example-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch efk-springboot-docker-kubernetes-example-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","efk-springboot-docker-kubernetes-example-0.0.1-SNAPSHOT.jar"]