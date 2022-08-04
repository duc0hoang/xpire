package com.xpire.app.utils;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.xpire.app.dtos.ResponseDTO;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

@UtilityClass
public class ResponseUtils {
    public static ResponseDTO get(Object data, HttpStatus httpStatus) {
        return ResponseDTO.builder()
                .data(data)
                .hasError(false)
                .error(null)
                .timestamp(DateTimeUtils.now())
                .status(httpStatus.value())
                .build();
    }

    public static ResponseDTO error(HttpClientErrorException e) {
        return ResponseDTO.builder()
                .data(Collections.emptyList())
                .hasError(true)
                .error(e.getMessage())
                .timestamp(DateTimeUtils.now())
                .status(e.getRawStatusCode())
                .build();
    }

    public static ResponseDTO error(JsonMappingException e) {
        return ResponseDTO.builder()
                .data(Collections.emptyList())
                .hasError(true)
                .error(e.getMessage())
                .timestamp(DateTimeUtils.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    public static ResponseDTO error(ResponseStatusException e) {
        return ResponseDTO.builder()
                .data(Collections.emptyList())
                .hasError(true)
                .error(e.getMessage())
                .timestamp(DateTimeUtils.now())
                .status(e.getRawStatusCode())
                .build();
    }

    public static ResponseDTO error(Exception e) {
        return ResponseDTO.builder()
                .data(Collections.emptyList())
                .hasError(true)
                .error(e.getMessage())
                .timestamp(DateTimeUtils.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }
}
