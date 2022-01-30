package com.api.airport.infrastructure.exception.exceptions;

import com.api.airport.infrastructure.exception.ErrorCodeDescription;
import lombok.Getter;

@Getter
public class AirportException extends RuntimeException {
    private ErrorCodeDescription errorCodeDescription;

    public AirportException(ErrorCodeDescription errorCodeDescription) {
        this.errorCodeDescription = errorCodeDescription;
    }
}
