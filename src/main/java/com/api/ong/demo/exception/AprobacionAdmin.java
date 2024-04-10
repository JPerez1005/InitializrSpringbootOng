package com.api.ong.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author perez
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AprobacionAdmin extends Exception{
    private long id;
    private String code;   
    private HttpStatus httpStatus;
    
    public AprobacionAdmin(long id, String code, String message,HttpStatus httpStatus) {
        super(message);
        this.id = id;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public AprobacionAdmin(String code, String message,HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
    
    public AprobacionAdmin(String message, Throwable cause) {
        super(message, cause);
    }   
}
