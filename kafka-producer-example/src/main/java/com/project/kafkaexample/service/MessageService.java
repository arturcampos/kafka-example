package com.project.kafkaexample.service;

import com.project.kafkaexample.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
public class MessageService {

  @Value(value = "${kafka.topic-name}")
  private String topicName;

  @Autowired private KafkaTemplate<String, Object> kafkaTemplate;

  public void sendMessage(Person person) {

      Message<Person> message = MessageBuilder
            .withPayload(person)
            .setHeader(KafkaHeaders.TOPIC, topicName)
            .build();

    ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(message);

    future.addCallback(
        new ListenableFutureCallback<>() {

          @Override
          public void onSuccess(SendResult<String, Object> result) {
            log.info(
                "Sent message=[{}] with recordMetadata=[{}]", message, result.getRecordMetadata());
          }

          @Override
          public void onFailure(Throwable ex) {
            System.out.println(
                "Unable to send message=[" + message + "] due to : " + ex.getMessage());
            throw new RuntimeException(
                "Unable to send message=[" + message + "] due to : " + ex.getMessage());
          }
        });
  }
}
