package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoCiudad;
import com.api.ong.demo.dto.DtoSocio;
import com.api.ong.demo.models.Ciudad;
import com.api.ong.demo.models.Socio;
import org.springframework.stereotype.Component;

/**
 * @author perez
 */

@Component
public class MapperCiudad {

    public DtoCiudad toDto(Ciudad c){
        DtoCiudad dtoC=new DtoCiudad();
        dtoC.setId(c.getId());
        dtoC.setNombre(c.getNombre());
        
        return dtoC;
    }
    
    public Ciudad toEntity(DtoCiudad dtoC){
        Ciudad c=new Ciudad();
        c.setId(dtoC.getId());
        c.setNombre(dtoC.getNombre());
        return c;
    }
    
}
