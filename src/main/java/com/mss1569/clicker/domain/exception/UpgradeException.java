package com.mss1569.clicker.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UpgradeException extends RuntimeException{
    public UpgradeException(String message) {
        super(message);
    }
}
