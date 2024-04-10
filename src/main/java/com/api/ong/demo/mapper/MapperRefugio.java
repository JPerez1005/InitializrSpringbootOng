package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoCiudad;
import com.api.ong.demo.dto.DtoRefugio;
import com.api.ong.demo.models.Ciudad;
import com.api.ong.demo.models.Refugio;
import org.springframework.stereotype.Component;

/**
 * @author perez
 */

@Component
public class MapperRefugio {
    
    public DtoRefugio toDto(Refugio r){
        DtoRefugio dtoR=new DtoRefugio();
        dtoR.setId(r.getId());
        dtoR.setUbicacion(r.getUbicacion());
        if(r.getCiudad()!=null){
            Ciudad c=r.getCiudad();
            DtoCiudad dtoC=new DtoCiudad();
            dtoC.setId(c.getId());
            dtoC.setNombre(c.getNombre());
            dtoR.setDtoCiudad(dtoC);
        }
        return dtoR;
    }
    
    public Refugio toEntity(DtoRefugio dtoR){
        
        Refugio r=new Refugio();
        
        r.setId(dtoR.getId());
        r.setUbicacion(dtoR.getUbicacion());
        
        if(dtoR.getDtoCiudad()!=null){
            DtoCiudad dtoC=new DtoCiudad();
            Ciudad c=new Ciudad();
            c.setId(dtoC.getId());
            c.setNombre(dtoC.getNombre());
            r.setCiudad(c);
        }
        return r;
    }
    
}
