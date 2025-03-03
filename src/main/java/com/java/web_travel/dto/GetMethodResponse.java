package com.java.web_travel.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetMethodResponse<T> {
    private boolean status;
    private String message;
    private T data;
    private String errorCode;
    private int httpCode;
}