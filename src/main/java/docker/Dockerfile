FROM java:8
VOLUME /tmp
ADD interface-0.1.0.jar /home/yifan/app.jar
ADD ../application.properties /home/yifan/application.properties
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/yifan/app.jar"]