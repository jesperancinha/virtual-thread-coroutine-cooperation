#!/usr/bin/env sh
java -XX:+PrintFlagsFinal -version | grep HeapSize
java -Xms350m -Xmx350m -jar warehouse-fulfilment.jar --spring.profiles.active=docker