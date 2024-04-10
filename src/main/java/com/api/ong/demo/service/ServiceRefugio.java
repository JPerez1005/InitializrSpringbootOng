package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoRefugio;
import com.api.ong.demo.dto.DtoSocio;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServiceRefugio {

    List<DtoRefugio> getAllRefugios();
    
    Optional<DtoSocio> getRefugioById(Long id);
    
    DtoRefugio createRefugio(Long sedeId,Long personaId,DtoRefugio dtoRefugio) throws ParseException;
    
    DtoRefugio updateRefugio(Long id,DtoRefugio dtoRefugio) throws ParseException;
    
    void deleteRefugio(Long id);
    
}
