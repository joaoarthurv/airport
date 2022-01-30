package com.api.airportsystem.infrastructure.exception.exceptions;

import com.api.airportsystem.infrastructure.exception.ErrorCodeDescription;
import lombok.Getter;

@Getter
public class FlightException extends RuntimeException {
    private ErrorCodeDescription errorCodeDescription;

    public FlightException(ErrorCodeDescription errorCodeDescription) {
        this.errorCodeDescription = errorCodeDescription;
    }
}
