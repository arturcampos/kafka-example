package com.project.kafkaexample.converter;

import com.project.kafkaexample.dto.SampleRequest;
import com.project.kafkaexample.domain.Person;
import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonMapper {
    public static Person sourceToDestination(SampleRequest source){
        return Person.builder()
              .identifier(UUID.randomUUID().toString())
              .name(source.getName())
              .email(source.getEmail())
              .build();
    }

}