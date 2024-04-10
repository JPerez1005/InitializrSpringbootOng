package com.api.ong.demo.dto;

import lombok.Data;

/**
 * @author perez
 */

@Data
public class DtoMedicamentos {
    
    private Long id;
    private int unidades;
    private DtoEnvioMaterial dtoEnvioMaterial;
    
}
