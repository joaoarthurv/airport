package com.api.airportsystem.infrastructure.exception.exceptions;

import com.api.airportsystem.infrastructure.exception.ErrorCodeDescription;
import lombok.Getter;

@Getter
public class AirportException extends RuntimeException {
    private ErrorCodeDescription errorCodeDescription;

    public AirportException(ErrorCodeDescription errorCodeDescription) {
        this.errorCodeDescription = errorCodeDescription;
    }
}
