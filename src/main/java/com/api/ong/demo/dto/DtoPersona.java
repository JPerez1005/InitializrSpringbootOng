package com.api.ong.demo.dto;

import lombok.Data;

/**
 * @author perez
 */

@Data
public class DtoPersona {
    
    private Long id;
    
    private String primer_nombre;
    
    private String segundo_nombre;
    
    private String primer_apellido;
    
    private String segundo_apellido;
    
    private String numero_identificacion;
    
    private String telefono;
    
    private String rol;
    
    private String email;
    
    private String password;
    
    private String status;
    
}
