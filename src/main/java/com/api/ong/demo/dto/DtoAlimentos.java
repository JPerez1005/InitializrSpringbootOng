package com.api.ong.demo.dto;

import lombok.Data;

/**
 * @author perez
 */
@Data
public class DtoAlimentos {

    private Long id;
    private float numero_toneladas;
    private DtoEnvioMaterial dtoEnvioMaterial;
    
}
