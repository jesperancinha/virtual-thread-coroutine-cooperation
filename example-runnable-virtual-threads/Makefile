include ../Makefile.mk
b:
	gradle clean build
example-curl:
	curl http://localhost:8080/api/v1/fulfilment
launch-locust:
	locust -f locust_fulfilment.py --host=http://localhost:8080
dcup:
	docker-compose up -d
dcup-rebuild:
	docker-compose down
	docker-compose up -d --build --force-recreate
