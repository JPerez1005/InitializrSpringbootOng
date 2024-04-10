package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoDirector;
import com.api.ong.demo.dto.DtoPersona;
import com.api.ong.demo.models.Director;
import com.api.ong.demo.models.Persona;
import org.springframework.stereotype.Component;

/**
 * @author perez
 */

@Component
public class MapperDirector {

    public DtoDirector toDto(Director d){
        DtoDirector dtoD=new DtoDirector();
        dtoD.setId(d.getId());
        
        if (d.getPersona()!=null) {
            Persona p=d.getPersona();
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
            
            dtoD.setDtoPersona(dtoP);
        }
        return dtoD;
    }
    
    public Director toEntity(DtoDirector dtoD){
        Director d=new Director();
        
        d.setId(dtoD.getId());
        
        if(dtoD.getDtoPersona()!=null){
            /*los datos del dto director los pasamos a la dto de persona*/
            DtoPersona dtoP=dtoD.getDtoPersona();
            Persona p=new Persona();//nueva persona
            p.setId(dtoP.getId());//mandamos el id que teniamos en dtopersona
            d.setPersona(p);//mandamos ese id a esa entidad
        }
        return d;
    }
    
}
