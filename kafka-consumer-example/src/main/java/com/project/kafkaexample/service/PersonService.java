package com.project.kafkaexample.service;

import com.project.kafkaexample.domain.Person;
import com.project.kafkaexample.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository repository;

  public void save(Person person) {
    log.info("[m=save] saving person={}", person);
    repository.save(person);
  }
}
