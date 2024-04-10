package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoAlimentos;
import com.api.ong.demo.dto.DtoEnvioMaterial;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServiceAlimentos {

    List<DtoAlimentos> getAllAlimentos();
    
    Optional<DtoAlimentos> getAlimentoById(Long id);
    
    DtoAlimentos createAlimento(Long envioId,DtoAlimentos dtoAlimentos) throws ParseException;
    
    DtoAlimentos updateAlimento(Long id,DtoAlimentos dtoAlimentos) throws ParseException;
    
    void deleteAlimento(Long id);
    
}
