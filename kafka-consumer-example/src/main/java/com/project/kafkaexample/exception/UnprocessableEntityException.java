package com.project.kafkaexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends APIException {

    public UnprocessableEntityException(Throwable cause) {
        super(cause);
    }

    public UnprocessableEntityException(ErrorMessage error) {
        super(error);
    }

    public UnprocessableEntityException(String error) {
        super(error);
    }
}
