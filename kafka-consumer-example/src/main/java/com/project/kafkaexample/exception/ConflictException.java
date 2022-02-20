package com.project.kafkaexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends APIException {

    public ConflictException(final Throwable cause) {
        super(cause);
    }

    public ConflictException(final ErrorMessage error) {
        super(error);
    }

    public ConflictException(final String error) {
        super(error);
    }
}
