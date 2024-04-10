package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoDirector;
import com.api.ong.demo.dto.DtoSede;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServiceSede {
    
    List<DtoSede> getAllSedes();
    
    Optional<DtoSede> getSedeById(Long id);
    
    DtoSede createSede(Long ciudadId,Long directorId,DtoSede dtoSede) throws ParseException;
    
    DtoSede updateSede(Long id, DtoSede dtoSede) throws ParseException;
    
    void deleteSede(Long id);
}
