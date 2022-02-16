package com.project.kafkaexample.api;

import com.project.kafkaexample.dto.SampleRequest;
import com.project.kafkaexample.converter.PersonMapper;
import com.project.kafkaexample.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MessageAPI {

  @Autowired private MessageService messageService;

  @PostMapping("/send")
  public ResponseEntity<Void> postMessage(@RequestBody SampleRequest request) {
    messageService.sendMessage(PersonMapper.sourceToDestination(request));
    return ResponseEntity.ok().build();
  }
}
