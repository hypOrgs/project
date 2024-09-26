FROM openjdk:11
WORKDIR /app
ENV JAR_FILE=/app/app.jar \
    JAR_OPTS="-Dloader.path=."


COPY ../../project-biz/target/*.jar ./app.jar
COPY ./start.sh ./start.sh

# start the script to run your application. Take note that there are several other optional environment variables supported
# for details, please see the start.sh.
ENTRYPOINT ["/bin/bash", "start.sh"]
