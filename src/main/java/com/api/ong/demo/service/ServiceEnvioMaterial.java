package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoEnvioHumanitario;
import com.api.ong.demo.dto.DtoEnvioMaterial;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServiceEnvioMaterial {
    List<DtoEnvioMaterial> getAllEnviosMaterial();
    
    Optional<DtoEnvioMaterial> getEnvioMaterialById(Long id);
    
    DtoEnvioMaterial createEnvioMaterial(Long envioId,DtoEnvioMaterial dtoEnvioMaterial) throws ParseException;
    
    DtoEnvioMaterial updateEnvioMaterial(Long id,DtoEnvioMaterial dtoEnvioMaterial) throws ParseException;
    
    void deleteEnvioMaterial(Long id);
}
