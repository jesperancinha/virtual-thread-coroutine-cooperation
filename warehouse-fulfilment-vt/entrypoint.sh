#!/usr/bin/env sh
java -XX:+PrintFlagsFinal -version | grep HeapSize
java -Xms500m -Xmx500m -jar warehouse-fulfilment.jar --spring.profiles.active=docker