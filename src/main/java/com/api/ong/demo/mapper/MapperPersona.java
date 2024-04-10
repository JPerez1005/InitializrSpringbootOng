package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoPersona;
import com.api.ong.demo.models.Persona;
import org.springframework.stereotype.Component;

/**
 * @author perez
 */

@Component
public class MapperPersona {
    
    //Pasamos datos entidad a dto
    public DtoPersona toDto(Persona p){
        DtoPersona dtoP=new DtoPersona();
        dtoP.setId(p.getId());
        dtoP.setPrimer_nombre(p.getPrimer_nombre());
        dtoP.setSegundo_nombre(p.getSegundo_nombre());
        dtoP.setPrimer_apellido(p.getPrimer_apellido());
        dtoP.setSegundo_apellido(p.getSegundo_apellido());
        dtoP.setNumero_identificacion(p.getNumero_identificacion());
        dtoP.setTelefono(p.getTelefono());
        dtoP.setRol(p.getRol());
        dtoP.setEmail(p.getEmail());
        dtoP.setPassword(p.getPassword());
        dtoP.setStatus(p.getStatus());
        return dtoP;
    }
    
    //Pasamos datos dto a entidad
    public Persona toEntity(DtoPersona dtoP){
        Persona p=new Persona();
        p.setId(dtoP.getId());
        p.setPrimer_nombre(dtoP.getPrimer_nombre());
        p.setSegundo_nombre(dtoP.getSegundo_nombre());
        p.setPrimer_apellido(dtoP.getPrimer_apellido());
        p.setSegundo_apellido(dtoP.getSegundo_apellido());
        p.setNumero_identificacion(dtoP.getNumero_identificacion());
        p.setTelefono(dtoP.getTelefono());
        p.setRol(dtoP.getRol());
        p.setEmail(dtoP.getEmail());
        p.setPassword(dtoP.getPassword());
        p.setStatus(dtoP.getStatus());
        System.out.println(p);
        return p;
    }
}
