package com.api.ong.demo.dto;

import java.util.Date;
import lombok.Data;

/**
 * @author perez
 */

@Data
public class DtoEnvio {

    private Long id;
    private String fecha_salida;
    private DtoRefugio dtorefugio;
    private DtoSede dtoSede;
    
}
