package com.pkmn.api.response;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiResponse{

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private Integer code;
    private String status;
    private Object value;

    public ApiResponse() {
    }

    public ApiResponse(HttpStatus httpStatus, Object object) {
        this.timestamp = LocalDateTime.now();
        code = httpStatus.value();
        status = httpStatus.name();
        value = object;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    
}
