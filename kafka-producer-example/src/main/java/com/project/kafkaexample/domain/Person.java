package com.project.kafkaexample.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {

  private String identifier;

  private String name;

  private String email;
}
