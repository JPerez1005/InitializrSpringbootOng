package com.api.ong.demo.service.impl;

import com.api.ong.demo.dto.DtoDirector;
import com.api.ong.demo.dto.DtoPersona;
import com.api.ong.demo.mapper.MapperDirector;
import com.api.ong.demo.mapper.MapperPersona;
import com.api.ong.demo.models.Director;
import com.api.ong.demo.models.Persona;
import com.api.ong.demo.repository.RepositoryDirector;
import com.api.ong.demo.repository.RepositoryPersona;
import com.api.ong.demo.service.ServiceDirector;
import com.api.ong.demo.service.ServicePersona;
import jakarta.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author perez
 */

@Service
public class ServiceImplDirector implements ServiceDirector{

    @Autowired
    private RepositoryDirector rd;
    
    @Autowired
    private MapperDirector md;
    
    @Autowired
    private RepositoryPersona rp;
    
    @Autowired
    private ServicePersona sp;
    
    @Autowired
    private MapperPersona mp;
    
    
    
    @Override
    public List<DtoDirector> getAllDirector() {
        List<Director> directores=rd.findAll();
        return directores.stream()
                .map(md::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DtoDirector> getDirectorById(Long id) {
        Optional<Director> director=rd.findById(id);
        return director.map(md::toDto);
    }

    @Override
    public DtoDirector createDirector(Long personaId, DtoDirector dtoDirector) throws ParseException {
        try {
            // Buscamos una persona
            DtoPersona dtoP = sp.getPersonaById(personaId)
                    .orElseThrow(() -> new EntityNotFoundException("Persona no encontrada"));

            // Cargar la entidad Persona asociada con la sesión actual de Hibernate
            Persona persona = rp.findById(dtoP.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Persona no encontrada"));

            // Crear un nuevo objeto Director y asociarlo con la entidad Persona
            Director director = new Director();
            director.setPersona(persona);

            // Guardar el objeto Director
            Director directorCreado = rd.save(director);
            return md.toDto(directorCreado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public DtoDirector updateDirector(Long id, DtoDirector dtoDirector) throws ParseException {
        Optional<Director> directorOptional=rd.findById(id);
        
        if(directorOptional.isPresent()){
            Director d=directorOptional.get();
            
//            d.setId(dtoDirector.getId());
            
            Director updateDirector=rd.save(d);
            
            //Obtenemos la persona
            DtoPersona dtoP=dtoDirector.getDtoPersona();
            if(dtoP!=null){
                Persona p=d.getPersona();
                if(p!=null){
                    rp.save(p);
                }
            }
            return md.toDto(updateDirector);
        }
        return null;
    }

    @Override
    public void deleteDirector(Long id) {
        rd.deleteById(id);
    }

}
