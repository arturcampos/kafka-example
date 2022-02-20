package com.project.kafkaexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
public class BusinessException extends APIException {

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(ErrorMessage error) {
        super(error);
    }

    public BusinessException(String error) {
        super(error);
    }
}
