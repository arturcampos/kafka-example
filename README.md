# Kafka example ![Kafka](https://img.shields.io/badge/Apache%20Kafka-darkblue?style=plastic&logo=apachekafka) ![Profile last updated](https://img.shields.io/github/last-commit/arturcampos/kafka-example/main?label=Last%20updated&style=plastic)  


## Functionalities to be added 
- [x] MongoDB integration
- [ ] Unit tests
- [ ] Integration Tests
- [ ] CI/CD with Git actions
- [ ] Postman Documentation


### To run this project you will need:
- ![Java11](https://img.shields.io/badge/Java11-darkgreen?style=plastic&logo=java)
- ![ApacheMaven](https://img.shields.io/badge/Apache%20Maven-darkgreen?style=plastic&logo=apachemaven)
- ![Docker](https://img.shields.io/badge/Docker-darkgreen?style=plastic&logo=docker)
- ![Docker-Compose](https://img.shields.io/badge/Docker%20Compose-darkblue?style=plastic&logo=docker-compose)

### Project structure

``` 
Project
├── kafka-producer-example
|   ├── Dockerfile
|   ├── src
|      ├── main
|         ├── java/com/project/kafkaexample
|            ├── service: contains all of service implementation and business rules
|            ├── dto: contains data transfer objects used in the integrations
|            ├── api: contains controller and apis interfaces
|            ├── config: contains all spring bean configuration
|            ├── domain: contains all domain entity objects/classes
             ├── exception: contains all exception handlers
|         ├── resource: contains property files and static content
├── kafka-consumer-example
|   ├── Dockerfile
|   ├── src
|      ├── main
|         ├── java/com/project/kafkaexample
|            ├── service: contains all of service implementation and business rules
|            ├── dto: contains data transfer objects used in the integrations
|            ├── api: contains controller and apis interfaces
|            ├── respository: contains all interfaces with data-bases
|            ├── config: contains all spring bean configuration
|            ├── domain: contains all domain entity objects/classes
|            ├── exception: contains all exception handlers
|         ├── resource: contains property files and static content
├── docker-compose.yml

```


### How to build and run:
After downloading the repository, to run from scratch you must following the steps bellow: ⏬

If you want to run it from scratch: 🔰
- ▶️ go to ./kafka-consumer-example and run `mvn clean package -DskipTests`;
- Come back to root dir;
- ▶️ go to ./kafka-producer-example and run `mvn clean package -DskipTests`;
- Come back to root dir (again);
- ▶️ run `docker-compose up build -d` or simply `docker-compose up -d`
- wait until all containers are up and runing

### Testing:
Now it's time to use these examples by calling an api using curl or any other tools you prefer: 👽
```sh
curl -X POST 'http://localhost:8080/api/send' -d '{"name":"Full Name", "email": "email@email.com"}' -H 'content-type: application/json'
```

### Validating:
To check if everything was ok, go to terminal and type following commands:
- `docker logs kafka-producer` to show kafka producer logs (here you should see a log saying you've sent a message) 🟢
- `docker logs kafka-consumer` to show kafka consumer logs (here you should see a log saying you've receved a new message) 🟢
- Now it's possible to query through API the sample message sent from producer to customer:
    - query all people in data-base:   
    ```sh
    curl 'http://localhost:8081/api/people?number=0&size=10'
    ```
    - query specific person using id: (remember replacing {id} for a valid id returned in the first query)
    ```sh
    curl 'http://localhost:8081/api/people/{id}'
    ```

### Contact
[![Gmail Badge](https://img.shields.io/badge/-arturcampos13@gmail.com-c14438?style=flat&logo=Gmail&logoColor=white)](mailto:arturcampos13@gmail.com "Connect via Email")
[![Linkedin Badge](https://img.shields.io/badge/-arturcamposrodrigues-0072b1?style=flat&logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/arturcamposrodrigues/?locale=en_US/ "Connect on LinkedIn")
[![Twitter Badge](https://img.shields.io/badge/-@_artur_campos-00acee?style=flat&logo=Twitter&logoColor=white)](https://twitter.com/intent/follow?screen_name=_artur_campos "Follow on Twitter")