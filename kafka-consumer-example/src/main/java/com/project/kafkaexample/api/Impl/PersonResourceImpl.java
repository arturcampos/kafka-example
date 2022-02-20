package com.project.kafkaexample.api.Impl;

import com.project.kafkaexample.api.PersonResource;
import com.project.kafkaexample.converter.PersonMapper;
import com.project.kafkaexample.dto.PersonDTO;
import com.project.kafkaexample.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class PersonResourceImpl implements PersonResource {

  private final PersonService service;

  @GetMapping("/people")
  public ResponseEntity<Page<PersonDTO>> getAll(Pageable pageable) {
    return ResponseEntity.ok(PersonMapper.getPersonPage(service.getAll(pageable)));
  }

  @GetMapping("/people/{id}")
  public ResponseEntity<PersonDTO> getById(@PathVariable("id") String id) {
    return ResponseEntity.ok(PersonMapper.fromDomain(service.getById(id)));
  }
}
