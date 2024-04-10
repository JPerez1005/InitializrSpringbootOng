package com.api.ong.demo.dto;

import lombok.Data;

/**
 * @author perez
 */

@Data
public class DtoSocio {
    
    private Long id;
    private String cuenta_bancaria;
    private String fecha_pago;
    private String tipo_cuota;
    private Long sedeId;
    private DtoPersona dtoPersona;

}
