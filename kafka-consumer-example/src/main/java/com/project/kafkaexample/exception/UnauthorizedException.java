package com.project.kafkaexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends APIException {

    public UnauthorizedException(Throwable cause) {
        super(cause);
    }

    public UnauthorizedException(ErrorMessage error) {
        super(error);
    }

    public UnauthorizedException(String error) {
        super(error);
    }
}
