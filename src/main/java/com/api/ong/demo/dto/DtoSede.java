package com.api.ong.demo.dto;

import lombok.Data;

/**
 * @author perez
 */

@Data
public class DtoSede {

    private Long id;
    private DtoDirector Director;
    private DtoCiudad Ciudad;
    
}
