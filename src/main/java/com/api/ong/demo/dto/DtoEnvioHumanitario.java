package com.api.ong.demo.dto;

import lombok.Data;

/**
 * @author perez
 */

@Data
public class DtoEnvioHumanitario {

    private Long id;
    
    private int numero_voluntarios;
    
    private DtoEnvio dtoEnvio;
    
}
