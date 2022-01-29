package com.api.airport.infrastructure.exception;

import lombok.Getter;

@Getter
public class AirportException extends RuntimeException {
    private ErrorCodeDescription errorCodeDescription;

    public AirportException(ErrorCodeDescription errorCodeDescription){
        this.errorCodeDescription = errorCodeDescription;
    }
}
