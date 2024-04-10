package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoPersona;
import com.api.ong.demo.exception.AprobacionAdmin;
import com.api.ong.demo.exception.ErrorGeneral;
import com.api.ong.demo.exception.ErrorValidacion;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

/**
 * @author perez
 */
public interface ServicePersona {

    DtoPersona signUp(DtoPersona dtoP) throws ErrorGeneral;

    ResponseEntity<String> login(Map<String, String> requestMap) throws AprobacionAdmin,ErrorValidacion;
    
    List<DtoPersona> getAllUsers() throws AprobacionAdmin,ErrorGeneral;
    
    DtoPersona updatePersonaStatus(Long id, DtoPersona dtoP);
    
    ResponseEntity<String> validarToken();
    
    ResponseEntity<String> cambiarContraseña(Map<String,String> requestMap);

    ResponseEntity<String> forgotPassword(Map<String, String> requestMap);
    
    Optional<DtoPersona> getPersonaById(Long id);
    
}
