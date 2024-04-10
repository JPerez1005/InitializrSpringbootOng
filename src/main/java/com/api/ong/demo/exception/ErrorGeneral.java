package com.api.ong.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author perez
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class ErrorGeneral extends Exception{
    private long id;
    private String code;   
    private HttpStatus httpStatus;
    
    public ErrorGeneral(long id, String code, String message,HttpStatus httpStatus) {
        super(message);
        this.id = id;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public ErrorGeneral(String code, String message,HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
    
    public ErrorGeneral(String message, Throwable cause) {
        super(message, cause);
    }   
}
