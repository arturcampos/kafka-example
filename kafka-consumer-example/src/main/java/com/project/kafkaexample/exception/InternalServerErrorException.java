package com.project.kafkaexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends APIException {

    public InternalServerErrorException(Throwable cause) {
        super(cause);
    }

    public InternalServerErrorException(ErrorMessage error) {
        super(error);
    }

    public InternalServerErrorException(String error) {
        super(error);
    }
}
