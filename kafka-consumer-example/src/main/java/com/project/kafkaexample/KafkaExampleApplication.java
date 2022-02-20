package com.project.kafkaexample;

import com.project.kafkaexample.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class KafkaExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaExampleApplication.class, args);
  }
}
