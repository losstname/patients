package com.umrwhk.patients.dto;

import org.springframework.http.HttpStatus;

/**
 * Created by umrwhk(umrwhk@gmail.com)
 */
public class MetaData {
    private int code;
    private String message;

    public MetaData() {
    }

    public MetaData(HttpStatus httpStatus) {
        this.code = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
    }

    public MetaData(HttpStatus httpStatus, String message) {
        this.code = httpStatus.value();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
