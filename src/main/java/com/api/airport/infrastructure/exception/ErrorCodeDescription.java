package com.api.airport.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCodeDescription {
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "API_ERROR_001", "Internal Server Error"),
    BAD_REQUEST_FOR_CREATE_FLIGHT(HttpStatus.BAD_REQUEST.value(), "API_ERROR_002", "Could not create flight"),
    NOT_FOUND_FLIGHT(HttpStatus.NOT_FOUND.value(), "API_ERROR_003", "Could not find flight"),
    NOT_FOUND_USER(HttpStatus.NOT_FOUND.value(), "API_ERROR_004", "Could not find user"),
    BAD_REQUEST_FOR_UPDATE_USER(HttpStatus.BAD_REQUEST.value(), "API_ERROR_005", "Could not update user"),
    BAD_REQUEST_FOR_DELETE_FLIGHT(HttpStatus.BAD_REQUEST.value(), "API_ERROR_006", "Could not delete flight"),
    BAD_REQUEST_FOR_UPDATE_FLIGHT(HttpStatus.BAD_REQUEST.value(), "API_ERROR_007", "Could not update flight"),
    BAD_REQUEST_FOR_DELETE_USER(HttpStatus.BAD_REQUEST.value(), "API_ERROR_008", "Could not delete user"),
    NOT_FOUND_FLIGHTS(HttpStatus.NOT_FOUND.value(), "API_ERROR_009", "Could not find flights registers");


    private final int status;
    private final String errorCode;
    private final String errorMessage;
}
