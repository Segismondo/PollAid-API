FROM openjdk:8

RUN apt-get update && \
    apt-get install -y htop && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /home/application
COPY . ./

RUN mv /home/application/*.jar /home/application/app.jar

CMD java ${JAVA_OPTS} -jar /home/application/app.jar ${APP_ARGS}