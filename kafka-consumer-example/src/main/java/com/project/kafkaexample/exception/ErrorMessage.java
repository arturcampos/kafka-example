package com.project.kafkaexample.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class ErrorMessage implements Serializable {

    private String message;

    private String link;

    private List<Error> errors = Lists.newArrayList();

    public ErrorMessage(final String msg) {
        this.message = msg;
    }

    public ErrorMessage(final String msg, final String link) {
        this.message = msg;
        this.link = link;
    }

    public ErrorMessage(final String msg, final List<Error> errors) {
        this.message = msg;
        this.errors = errors;
    }

    public ErrorMessage(final String msg, final List<Error> errors, final String link) {
        this.message = msg;
        this.errors = errors;
        this.link = link;
    }

    public void addError(final Error error) {
        errors.add(error);
    }
}
