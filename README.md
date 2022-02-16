# kafka-example

### To run this project you will need:
- Java11
- maven
- docker
- docker compose

### Steps:
If you want to run it from scratch:
- go to ./kafka-consumer-example and run `mvn clean package -DskipTests`;
- Come back to root dir;
- go to ./kafka-producer-example and run `mvn clean package -DskipTests`;
- Come back to root dir (again);
- run `docker-compose up build -d` or simply `docker-compose up -d`
- wait until all containers are up and runing

### Testing:
Now it's time to user these examples by calling an api using curl or any other tools you prefer:
```sh
    curl -X POST 'http://localhost:8080/api/send' -d '{"name":"Full Name", "email": "email@email.com"}' -H 'content-type: application/json'
```

### Validating:
To check if everything was ok, go to terminal and type following commands:
- `docker logs kafka-producer` to show kafka producer logs (here you should see a log saying you've sent a message)
- `docker logs kafka-consumer` to show kafka consumer logs (here you should see a log saying you've receved a new message)