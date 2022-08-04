package com.xpire.app.controllers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.xpire.app.dtos.ResponseDTO;
import com.xpire.app.utils.ResponseUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.NestedRuntimeException;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onWebExchangeBindException(WebExchangeBindException e) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            response.add(fieldError);
        }
        return response;
    }

    @ExceptionHandler(JsonMappingException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseDTO onJsonMappingException(JsonMappingException e) {
        return ResponseUtils.error(e);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseDTO onHttpClientErrorException(HttpClientErrorException e) {
        return ResponseUtils.error(e);
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseDTO onResponseStatusException(ResponseStatusException e) {
        return ResponseUtils.error(e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseDTO onException(Exception e) {
        return ResponseUtils.error(e);
    }

    @Getter
    public class ValidationErrorResponse {
        private final List<Violation> violations = new ArrayList<>();

        public void add(FieldError fieldError) {
            violations.add(new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
        }
    }

    @AllArgsConstructor
    @Getter
    public class Violation {
        private final String fieldName;
        private final String message;
    }
}


