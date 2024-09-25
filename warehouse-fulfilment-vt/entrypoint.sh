#!/usr/bin/env sh
java -XX:+PrintFlagsFinal -version | grep HeapSize
java -Xms400m -Xmx400m -jar warehouse-fulfilment.jar --spring.profiles.active=docker