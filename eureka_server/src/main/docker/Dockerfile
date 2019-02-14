FROM java:8

VOLUME ./tmp

ADD eureka_server-0.0.1-SNAPSHOT.jar eureka_server-0.0.1-SNAPSHOT.jar
RUN bash -c 'touch app.jar'

EXPOSE 8761

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka_server-0.0.1-SNAPSHOT.jar"]


