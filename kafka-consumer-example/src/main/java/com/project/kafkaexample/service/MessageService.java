package com.project.kafkaexample.service;

import com.project.kafkaexample.domain.Person;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageService {

  @Value(value = "${kafka.topic-name}")
  private String topicName;

  @Autowired private KafkaTemplate<String, Object> kafkaTemplate;

  @KafkaListener(
      topics = "${kafka.topic-name}",
      clientIdPrefix = "json",
      containerFactory = "kafkaListenerContainerFactory")
  public void listenAsObject(
      ConsumerRecord<String, Person> cr,
      @Payload Person payload,
      @Headers Map<String, Object> headers) {
    log.info(
        "Received key {}: Type [{}] | Payload: {} | Record: {}",
        cr.key(),
        getObjectType(headers.get("objectType")),
        payload,
        cr);
  }

  private Object getObjectType(Object objectType) {
    if (Objects.nonNull(objectType)) {
      return new String((byte[]) objectType, StandardCharsets.UTF_8);
    }
    return null;
  }
}
