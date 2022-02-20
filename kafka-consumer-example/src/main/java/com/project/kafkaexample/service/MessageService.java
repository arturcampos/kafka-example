package com.project.kafkaexample.service;

import com.project.kafkaexample.converter.PersonMapper;
import com.project.kafkaexample.domain.Person;
import com.project.kafkaexample.dto.PersonKafkaDTO;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

  private final PersonService personService;

  @KafkaListener(
      topics = "${kafka.topic-name}",
      clientIdPrefix = "json",
      containerFactory = "kafkaListenerContainerFactory")
  public void listenAsObject(
      ConsumerRecord<String, PersonKafkaDTO> cr,
      @Payload PersonKafkaDTO payload,
      @Headers Map<String, Object> headers) {
    log.info(
        "Received key {}: Type [{}] | Payload: {} | Record: {}",
        cr.key(),
        getObjectType(headers.get("__TypeId__")),
        payload,
        cr);

    //Person person = getPerson(payload, headers);

    personService.save(PersonMapper.toDomain(payload));
  }

  private Object getObjectType(Object objectType) {
    if (Objects.nonNull(objectType)) {
      return new String((byte[]) objectType, StandardCharsets.UTF_8);
    }
    return null;
  }
}
