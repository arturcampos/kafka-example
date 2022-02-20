package com.project.kafkaexample.service;

import com.project.kafkaexample.domain.Person;
import com.project.kafkaexample.exception.NotFoundException;
import com.project.kafkaexample.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

  private static final String NOT_FOUND_MSG = "Person not found";

  private final PersonRepository repository;

  public void save(Person person) {
    log.info("[m=save] saving person={}", person);
    repository.save(person);
  }

    public Page<Person> getAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

  public Person getById(String id) {
    return repository.findById(id).orElseThrow(
          () -> new NotFoundException(NOT_FOUND_MSG));
  }
}
