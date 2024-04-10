package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoPersona;
import com.api.ong.demo.dto.DtoPersonalAdministrativo;
import com.api.ong.demo.dto.DtoPersonalSanitario;
import com.api.ong.demo.dto.DtoVoluntario;
import com.api.ong.demo.models.Persona;
import com.api.ong.demo.models.PersonalAdministrativo;
import com.api.ong.demo.models.PersonalSanitario;
import com.api.ong.demo.models.Voluntario;
import com.api.ong.demo.repository.RepositoryVoluntario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author perez
 */

@Component
public class MapperPersonalSanitario {
    
    @Autowired
    private RepositoryVoluntario rv;
    
    //Pasamos datos entidad a dto
    public DtoPersonalSanitario toDto(PersonalSanitario ps){
        DtoPersonalSanitario dtoPS = new DtoPersonalSanitario();
        dtoPS.setId(ps.getId());
        dtoPS.setNumero_trabajos_hechos(ps.getNumero_trabajos_hechos());
        dtoPS.setProfesion(ps.getProfesion());
        dtoPS.setDisponibilidad(ps.isDisponibilidad());
        if (dtoPS.getDtoVoluntario() != null) {
            DtoVoluntario dtoV = new DtoVoluntario();
            Voluntario v=ps.getVoluntario();
            dtoV.setId(v.getId());
            dtoV.setIdSede(v.getSede().getId());
            if (v.getPersona() != null) {
                Persona p = v.getPersona();
                DtoPersona dtoP = new DtoPersona();

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
            dtoPS.setDtoVoluntario(dtoV);
        }
        return dtoPS;
    }
    
    //Pasamos datos dto a entidad
    public PersonalSanitario toEntity(DtoPersonalSanitario dtoPS){
        PersonalSanitario ps=new PersonalSanitario();
        ps.setId(dtoPS.getId());
        
        Optional<Voluntario> voluntario=rv.findById(dtoPS.getDtoVoluntario().getId());
        Voluntario directorBBDD=voluntario.get();
        ps.setVoluntario(directorBBDD);
        
        return ps;
    }
}
