package com.example.salestracking.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ResponseDto
{
    private boolean success;
    private Object detail;
    private String message;
    private int statusCode;
    private Map<String, String> errors;

    public ResponseDto(boolean success, Object detail, String message, int statusCode)
    {
        this.success = success;
        this.detail = detail;
        this.message = message;
        this.statusCode = statusCode;
    }
}
