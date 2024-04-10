package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoEnvio;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServiceEnvio {
    
    List<DtoEnvio> getAllEnvios();
    
    Optional<DtoEnvio> getEnvioById(Long id);
    
    DtoEnvio createEnvio(Long sedeId,DtoEnvio dtoEnvio) throws ParseException;
    
    DtoEnvio updateEnvio(Long id,DtoEnvio dtoEnvio) throws ParseException;
    
    void deleteEnvio(Long id);
    
}
