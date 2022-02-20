package com.project.kafkaexample.api;

import com.project.kafkaexample.dto.PersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface PersonResource {

    ResponseEntity<Page<PersonDTO>> getAll(Pageable pageable);
    ResponseEntity<PersonDTO> getById(@PathVariable("id") String id);

}
