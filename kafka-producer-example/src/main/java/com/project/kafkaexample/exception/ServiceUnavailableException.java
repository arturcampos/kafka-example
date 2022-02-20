package com.project.kafkaexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends APIException {

    public ServiceUnavailableException(Throwable cause) {
        super(cause);
    }

    public ServiceUnavailableException(ErrorMessage error) {
        super(error);
    }

    public ServiceUnavailableException(String error) {
        super(error);
    }
}
