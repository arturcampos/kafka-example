package com.project.kafkaexample.converter;

import com.project.kafkaexample.domain.Person;
import com.project.kafkaexample.dto.PersonDTO;
import com.project.kafkaexample.dto.PersonKafkaDTO;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

@UtilityClass
public class PersonMapper {

  public Person toDomain(PersonKafkaDTO source) {
    return Person.builder()
        .id(UUID.randomUUID().toString())
        .name(source.getName())
        .email(source.getEmail())
        .build();
  }

  public PersonDTO fromDomain(Person source) {
    return PersonDTO.builder()
        .id(source.getId())
        .name(source.getName())
        .email(source.getEmail())
        .build();
  }

  public PageImpl<PersonDTO> getPersonPage(Page<Person> clientPage) {
    return new PageImpl<>(
        clientPage.getContent().stream().map(PersonMapper::fromDomain).collect(Collectors.toList()),
        clientPage.getPageable(),
        clientPage.getTotalElements());
  }
}
