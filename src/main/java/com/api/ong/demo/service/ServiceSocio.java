package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoSede;
import com.api.ong.demo.dto.DtoSocio;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServiceSocio {
    List<DtoSocio> getAllSocios();
    
    Optional<DtoSocio> getSocioById(Long id);
    
    DtoSocio createSocio(Long sedeId,Long personaId,DtoSocio dtoSocio) throws ParseException;
    
    DtoSocio updateSocio(Long id, DtoSocio dtoSocio) throws ParseException;
    
    void deleteSocio(Long id);
}
