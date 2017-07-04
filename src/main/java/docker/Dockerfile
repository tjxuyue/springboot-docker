FROM java:8
ADD pom.xml /pom.xml  
ADD interface-0.1.0.jar /home/yifan/app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/yifan/app.jar"]