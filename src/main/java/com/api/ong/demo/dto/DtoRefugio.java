package com.api.ong.demo.dto;

import lombok.Data;

/**
 * @author perez
 */

@Data
public class DtoRefugio {

    private Long id;
    private String ubicacion;
    private DtoCiudad dtoCiudad;
    
}
