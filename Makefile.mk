SHELL := /bin/sh
GRADLE_VERSION ?= 8.10.1

b:

install:
	sdk install kotlin
install-locust:
	pip install locust
install-locust-linux:
	sudo apt-get install locust
install-python:
	pip install charset_normalizer
upgrade-pip:
	pip install --upgrade pip
stop-all-containers:
	docker ps -a -q --filter="name=warehouse" | xargs -I {} docker stop {}
	docker ps -a -q --filter="name=warehouse" | xargs -I {}  docker rm {}
	docker images -a -q --filter="reference=ware*" | xargs -I {} docker rmi {}
dcup:
	docker-compose up -d
dcup-rebuild: stop-all-containers
	docker-compose down
	docker-compose up -d --build --force-recreate
