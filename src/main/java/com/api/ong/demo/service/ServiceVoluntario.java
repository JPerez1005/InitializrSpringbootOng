package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoSocio;
import com.api.ong.demo.dto.DtoVoluntario;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServiceVoluntario {

    List<DtoVoluntario> getAllVoluntarios();
    
    Optional<DtoVoluntario> getVoluntarioById(Long id);
    
    DtoVoluntario createVoluntario(Long sedeId,Long personaId,DtoVoluntario dtoVoluntario) throws ParseException;
    
    DtoVoluntario updateVoluntario(Long id, DtoVoluntario dtoVoluntario) throws ParseException;
    
    void deleteVoluntario(Long id);
    
}
