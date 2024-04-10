package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoCiudad;
import com.api.ong.demo.dto.DtoDirector;
import com.api.ong.demo.dto.DtoPersona;
import com.api.ong.demo.dto.DtoRefugio;
import com.api.ong.demo.dto.DtoSede;
import com.api.ong.demo.models.Ciudad;
import com.api.ong.demo.models.Director;
import com.api.ong.demo.models.Persona;
import com.api.ong.demo.models.Refugio;
import com.api.ong.demo.models.Sede;
import com.api.ong.demo.repository.RepositoryCiudad;
import com.api.ong.demo.repository.RepositoryDirector;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author perez
 */

@Component
public class MapperSede {
    
    @Autowired
    private RepositoryCiudad rc;
    
    @Autowired
    private RepositoryDirector rd;

    public DtoSede toDto(Sede s){
        DtoSede dtoS=new DtoSede();
        
        dtoS.setId(s.getId());
        if(s.getCiudad()!=null){
            Ciudad c=s.getCiudad();
            DtoCiudad dtoC=new DtoCiudad();
            dtoC.setId(c.getId());
            dtoC.setNombre(c.getNombre());
            dtoS.setCiudad(dtoC);
        }
        if(s.getDirector()!=null){
            Director d=s.getDirector();
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
            dtoS.setDirector(dtoD);
        }
        
        return dtoS;
    }
    
    public Sede toEntity(DtoSede dtoS){
        Sede s=new Sede();
        
        s.setId(dtoS.getId());
        
        Optional<Director> director=rd.findById(dtoS.getDirector().getId());
        Director directorBBDD=director.get();
        s.setDirector(directorBBDD);
        
        Optional<Ciudad> ciudad=rc.findById(dtoS.getCiudad().getId());
        Ciudad ciudadBBDD=ciudad.get();
        s.setCiudad(ciudadBBDD);
        return s;
    }
    
}
