package com.project.kafkaexample.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.project.kafkaexample.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
public class MessageService {

  @Value(value = "${kafka.topic-name}")
  private String topicName;

  @Autowired
  private KafkaTemplate<String, Object> kafkaTemplate;

  public void sendMessage(Person message) {
      ProducerRecord<String, Object> record = new ProducerRecord<>(topicName, message);
      record.headers().add("objectType",Person.class.getSimpleName().getBytes());
    ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(record);

    future.addCallback(
          new ListenableFutureCallback<>() {

              @Override
              public void onSuccess(SendResult<String, Object> result) {
                  log.info("Sent message=[{}] with recordMetadata=[{}]", message, result.getRecordMetadata());
              }

              @Override
              public void onFailure(Throwable ex) {
                  System.out.println(
                        "Unable to send message=[" + message + "] due to : " + ex.getMessage());
                  throw new RuntimeException("Unable to send message=[" + message + "] due to : " + ex.getMessage());
              }
          });
  }
}
