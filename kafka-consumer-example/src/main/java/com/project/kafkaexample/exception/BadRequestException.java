package com.project.kafkaexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends APIException {

    public BadRequestException(final Throwable cause) {
        super(cause);
    }

    public BadRequestException(final ErrorMessage error) {
        super(error);
    }

    public BadRequestException(final String error) {
        super(error);
    }
}
