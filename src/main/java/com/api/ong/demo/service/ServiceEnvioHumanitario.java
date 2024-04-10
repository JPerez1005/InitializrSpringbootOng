package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoEnvio;
import com.api.ong.demo.dto.DtoEnvioHumanitario;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServiceEnvioHumanitario {

    List<DtoEnvioHumanitario> getAllEnviosHumanitarios();
    
    Optional<DtoEnvioHumanitario> getEnvioHumanitarioById(Long id);
    
    DtoEnvioHumanitario createEnvioHumanitario(Long envioId,DtoEnvioHumanitario dtoEnvioHumanitario) throws ParseException;
    
    DtoEnvioHumanitario updateEnvioHumanitario(Long id,DtoEnvioHumanitario dtoEnvioHumanitario) throws ParseException;
    
    void deleteEnvioHumanitario(Long id);
    
}
