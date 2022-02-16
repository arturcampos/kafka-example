# kafka-example

To run this project you will need:
- Java11
- maven
- docker
- docker compose

Steps:
    If you want to run it from scratch:
    1 - go to ./kafka-consumer-example and run `mvn clean package -DskipTests`;
    1.1 - Come back to root dir;
    2 - go to ./kafka-producer-example and run `mvn clean package -DskipTests`;
    2.1 - Come back to root dir;
    3 - run `docker-compose up build -d`
    4 - wait until all containers are up and runing

Now it's time to user these examples:
    Call an api using curl or any other tools you prefer.:
    `curl -X POST 'http://localhost:8080/api/send' -d '{"name":"Full Name", "email": "email@email.com"}' -H 'content-type: application/json'`

To check if everything was ok, go to terminal and type following commands:
    1 - `docker logs kafka-producer` to show kafka producer logs (here you should see a log saying you've sent a message)
    2 - `docker logs kafka-consumer` to show kafka consumer logs (here you should see a log saying you've receved a new message)

