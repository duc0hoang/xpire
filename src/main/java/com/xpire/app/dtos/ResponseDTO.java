package com.xpire.app.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseDTO {
    private Object data;
    private boolean hasError;
    private String error;
    private String timestamp;
    private int status;
}
