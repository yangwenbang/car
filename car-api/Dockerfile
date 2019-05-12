FROM java:8
EXPOSE 7070

VOLUME /tmp
ADD car-api.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
