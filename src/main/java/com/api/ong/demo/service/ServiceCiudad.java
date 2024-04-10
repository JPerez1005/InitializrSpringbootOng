package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoCiudad;
import com.api.ong.demo.dto.DtoSede;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServiceCiudad {

    List<DtoCiudad> getAllCiudades();
    
    Optional<DtoCiudad> getCiudadById(Long id);
    
    DtoCiudad createCiudad(DtoCiudad dtoCiudad);
    
    DtoCiudad updateCiudad(Long id,DtoCiudad dtoCiudad);
    
    void deleteCiudad(Long id);
    
}
