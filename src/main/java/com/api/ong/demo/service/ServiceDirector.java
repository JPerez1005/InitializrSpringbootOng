package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoDirector;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServiceDirector {

    List<DtoDirector> getAllDirector();
    
    Optional<DtoDirector> getDirectorById(Long id);
    
    DtoDirector createDirector(Long personaId,DtoDirector dtoDirector) throws ParseException;
    
    DtoDirector updateDirector(Long id, DtoDirector dtoDirector) throws ParseException;
    
    void deleteDirector(Long id);
    
}
