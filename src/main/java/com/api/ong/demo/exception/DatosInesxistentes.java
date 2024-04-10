package com.api.ong.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author perez
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class DatosInesxistentes extends Exception{
    private long id;
    private String code;   
    private HttpStatus httpStatus;
    
    public DatosInesxistentes(long id, String code, String message,HttpStatus httpStatus) {
        super(message);
        this.id = id;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public DatosInesxistentes(String code, String message,HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
    
    public DatosInesxistentes(String message, Throwable cause) {
        super(message, cause);
    }   
}
