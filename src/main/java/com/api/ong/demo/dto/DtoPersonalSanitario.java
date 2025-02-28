package com.api.ong.demo.dto;

import lombok.Data;

/**
 * @author perez
 */

@Data
public class DtoPersonalSanitario {
    private Long id;
    private String profesion;
    private boolean disponibilidad;
    private int numero_trabajos_hechos;
    private DtoVoluntario dtoVoluntario;
}
