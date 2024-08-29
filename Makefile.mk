SHELL := /bin/sh
GRADLE_VERSION ?= 8.10

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
