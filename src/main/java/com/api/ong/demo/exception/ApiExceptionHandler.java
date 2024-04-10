package com.api.ong.demo.exception;


import com.api.ong.demo.common.StandarizedApiExceptionResponse;
import java.io.IOException;
import java.net.UnknownHostException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author perez
 */

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleUnknownHostException(Exception ex) {
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error de conexion","erorr-1024",ex.getMessage());
        return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
    }
    
    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleUnknownHostException(UnknownHostException ex){
        StandarizedApiExceptionResponse response=new StandarizedApiExceptionResponse("error de conexión", "error-1024", ex.getMessage());
        return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
    }
    
    @ExceptionHandler(DatosInesxistentes.class)
    public ResponseEntity<StandarizedApiExceptionResponse> DatosInesxistentes(DatosInesxistentes ex){
        StandarizedApiExceptionResponse response=new StandarizedApiExceptionResponse("error de validación",ex.getCode(),ex.getMessage());
        return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
    }
    
    @ExceptionHandler(ErrorGeneral.class)
    public ResponseEntity<StandarizedApiExceptionResponse> ErrorGeneral(ErrorGeneral ex){
        StandarizedApiExceptionResponse response=new StandarizedApiExceptionResponse("algo salió mal",ex.getCode(),ex.getMessage());
        return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
    }
    
    @ExceptionHandler(AprobacionAdmin.class)
    public ResponseEntity<StandarizedApiExceptionResponse> AprobacionAdmin(AprobacionAdmin ex){
        StandarizedApiExceptionResponse response=new StandarizedApiExceptionResponse("falta aprobación",ex.getCode(),ex.getMessage());
        return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
    }
    
    @ExceptionHandler(ErrorValidacion.class)
    public ResponseEntity<StandarizedApiExceptionResponse> ErrorValidacion(ErrorValidacion ex){
        StandarizedApiExceptionResponse response=new StandarizedApiExceptionResponse("algo salió mal con los datos",ex.getCode(),ex.getMessage());
        return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
    }
}
