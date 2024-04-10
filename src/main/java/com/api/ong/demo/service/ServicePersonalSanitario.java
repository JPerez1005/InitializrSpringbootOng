package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoPersonalSanitario;
import com.api.ong.demo.dto.DtoSocio;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServicePersonalSanitario {
    List<DtoPersonalSanitario> getAllPersonalSanitario();
    
    Optional<DtoPersonalSanitario> getPersonalSanitarioById(Long id);
    
    DtoPersonalSanitario createPersonalSanitario(Long voluntarioId,DtoPersonalSanitario dtoPersonal) throws ParseException;
    
    DtoPersonalSanitario updatePersonalSanitario(Long id, DtoPersonalSanitario dtoPersonal) throws ParseException;
    
    void deletePersonalSanitario(Long id);
}
