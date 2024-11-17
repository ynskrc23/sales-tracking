package com.example.salestracking.controller;

import com.example.salestracking.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Map;

public abstract class BaseController
{
    protected ResponseEntity<ResponseDto> jsonResponse(Object detail, HttpStatus status)
    {
        ResponseDto response = new ResponseDto(true, detail,"", status.value());
        return new ResponseEntity<>(response, status);
    }

    protected ResponseEntity<ResponseDto> jsonError(String message, HttpStatus status, Map<String, String> errors)
    {
        ResponseDto response = new ResponseDto(false, null, message, status.value());
        response.setErrors(errors);
        return new ResponseEntity<>(response, status);
    }
}
