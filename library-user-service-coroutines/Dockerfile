FROM eclipse-temurin:21-alpine

ENV runningFolder /usr/local/bin/

WORKDIR ${runningFolder}

COPY build/libs/warehouse-fulfilment.jar ${runningFolder}/warehouse-fulfilment.jar

COPY entrypoint.sh ${runningFolder}

EXPOSE 8080

ENTRYPOINT ["entrypoint.sh"]
