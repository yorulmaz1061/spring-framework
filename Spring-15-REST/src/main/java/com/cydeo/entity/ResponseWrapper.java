package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {
    //These are some custom fields.
    //success=true/false, message=any custom message, any custom code
    // Object data body result coming from the Service.
    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(String message, Object data) {
        //we modified below
        this.success = true;
        this.message = message;
        //we modified below
        this.code = HttpStatus.OK.value();
        this.data = data;
    }
    public ResponseWrapper(String message) {
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }
}

