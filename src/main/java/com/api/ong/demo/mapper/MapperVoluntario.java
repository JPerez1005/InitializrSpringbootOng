package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoDirector;
import com.api.ong.demo.dto.DtoPersona;
import com.api.ong.demo.dto.DtoVoluntario;
import com.api.ong.demo.models.Director;
import com.api.ong.demo.models.Persona;
import com.api.ong.demo.models.Sede;
import org.springframework.stereotype.Component;
import com.api.ong.demo.models.Voluntario;
import com.api.ong.demo.repository.RepositorySede;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author perez
 */

@Component
public class MapperVoluntario {
    
    @Autowired
    private RepositorySede rs;
    
    public DtoVoluntario toDto(Voluntario v){
        DtoVoluntario dtoV=new DtoVoluntario();
        dtoV.setId(v.getId());
        dtoV.setIdSede(v.getSede().getId());
        if(v.getPersona()!=null){
            Persona p=v.getPersona();
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
            
            dtoV.setDtoPersona(dtoP);
        }
        return dtoV;
    }
    
    public Voluntario toEntity(DtoVoluntario dtoV){
        Voluntario v=new Voluntario();
        
        v.setId(dtoV.getId());
        Optional<Sede> sede=rs.findById(dtoV.getIdSede());
        Sede sedeBBDD=sede.get();
        v.setSede(sedeBBDD);
        if(dtoV.getDtoPersona()!=null){
            /*los datos del dto director los pasamos a la dto de persona*/
            DtoPersona dtoP=dtoV.getDtoPersona();
            Persona p=new Persona();//nueva persona
            p.setId(dtoP.getId());//mandamos el id que teniamos en dtopersona
            v.setPersona(p);//mandamos ese id a esa entidad
        }
        return v;
    }
}
