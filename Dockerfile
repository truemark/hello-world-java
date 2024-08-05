FROM amazoncorretto:21-al2023-headless
USER nobody
WORKDIR /home/app
COPY target/*.jar /home/app/
ENV MESSAGE="Hello Universe!"
EXPOSE 8080
ENTRYPOINT ["/bin/bash", "-c", "java -Xmx64m -jar *.jar"]
