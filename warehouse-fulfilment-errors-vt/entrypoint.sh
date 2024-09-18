#!/usr/bin/env sh
java -jar warehouse-fulfilment.jar -XX:ActiveProcessorCount=4 -Djdk.virtualThreadScheduler.maxPoolSize=4 -Djdk.virtualThreadScheduler.parallelism=4 -Djdk.tracePinnedThreads=full