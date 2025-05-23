SHELL := /bin/sh
GRADLE_VERSION ?= 8.14

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
	docker ps -a -q --filter="name=postgres" | xargs -I {} docker stop {}
	docker ps -a -q --filter="name=warehouse" | xargs -I {}  docker rm {}
	docker ps -a -q --filter="name=postgres" | xargs -I {}  docker rm {}
	docker images -a -q --filter="reference=ware*" | xargs -I {} docker rmi {}
	docker images -a -q --filter="reference=postgres*" | xargs -I {} docker rmi {}
remove-all-containers:
	docker ps -aq | xargs -I {} docker rm -f {}
dcup-full: b
	docker-compose up -d
dcup:
	docker-compose up -d
dcup-rebuild: stop-all-containers
	docker-compose down
	docker-compose up -d --build --force-recreate
