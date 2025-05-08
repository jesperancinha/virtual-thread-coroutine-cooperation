include ../Makefile.mk
b:
	gradle clean build
example-curl:
	curl http://localhost:8080/api/v1/fulfilment
example-process-users:
	curl http://localhost:8080/api/v1/fulfilment/users/1000
example-get-all-users:
	curl http://localhost:8080/api/v1/fulfilment/allUsers
example-messages:
	curl -X POST http://localhost:8080/api/v1/fulfilment/messages -H "Content-Type: application/json" -d '{"message":"!!!NOSTROMEOW Alert!!"}'
example-control-curl:
	curl http://localhost:8080/api/v1/fulfilment/control
launch-locust:
	locust -f locust_fulfilment.py --host=http://localhost:8080
dcup:
	docker-compose up -d
dcup-rebuild:
	docker-compose down
	docker-compose up -d --build --force-recreate
up:
	docker-compose up -d --build
down:
	docker-compose down
monitor:
	jcmd <PID> Thread.print
