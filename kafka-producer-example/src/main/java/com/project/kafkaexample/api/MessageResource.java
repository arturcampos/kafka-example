package com.project.kafkaexample.api;

import com.project.kafkaexample.dto.SampleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface MessageResource {

    ResponseEntity<Void> postMessage(@RequestBody SampleRequest request);

}
