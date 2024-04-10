package com.api.ong.demo.dto;

import lombok.Data;

/**
 * @author perez
 */

@Data
public class DtoVoluntario {
    private Long id;
    
    private Long idSede;
    
    private DtoPersona dtoPersona;
}
