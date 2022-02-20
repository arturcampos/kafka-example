package com.project.kafkaexample.exception;

import lombok.Getter;

@Getter
public abstract class APIException extends RuntimeException {

    private final ErrorMessage error;

    APIException(final Throwable cause) {
        super(cause);
        this.error = new ErrorMessage(cause.getMessage());
    }

    APIException(final ErrorMessage error) {
        super(error.getMessage());
        this.error = error;
    }

    APIException(final String error) {
        super(error);
        this.error = new ErrorMessage(error);
    }
}
