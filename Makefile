include Makefile.mk

b: build
build:
	./gradlew
wrapper:
	gradle wrapper
