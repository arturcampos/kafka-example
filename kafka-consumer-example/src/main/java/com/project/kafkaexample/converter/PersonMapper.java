package com.project.kafkaexample.converter;

import com.project.kafkaexample.domain.Person;
import com.project.kafkaexample.dto.PersonKafkaDTO;
import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonMapper {
  public static Person toDomain(PersonKafkaDTO source) {
    return Person.builder()
        .id(UUID.randomUUID().toString())
        .name(source.getName())
        .email(source.getEmail())
        .build();
  }
}
