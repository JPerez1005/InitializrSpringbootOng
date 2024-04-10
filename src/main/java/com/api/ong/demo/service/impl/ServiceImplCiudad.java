package com.api.ong.demo.service.impl;

import com.api.ong.demo.dto.DtoCiudad;
import com.api.ong.demo.mapper.MapperCiudad;
import com.api.ong.demo.models.Ciudad;
import com.api.ong.demo.models.Director;
import com.api.ong.demo.models.Sede;
import com.api.ong.demo.repository.RepositoryCiudad;
import com.api.ong.demo.service.ServiceCiudad;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author perez
 */

@Service
public class ServiceImplCiudad implements ServiceCiudad {

    @Autowired
    private RepositoryCiudad rc;
    
    @Autowired
    private MapperCiudad mc;
    
    @Override
    public List<DtoCiudad> getAllCiudades() {
        List<Ciudad> ciudades=rc.findAll();
        return ciudades.stream()
                .map(mc::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DtoCiudad> getCiudadById(Long id) {
        Optional<Ciudad> ciudad=rc.findById(id);
        return ciudad.map(mc::toDto);
    }

    @Override
    public DtoCiudad createCiudad(DtoCiudad dtoCiudad) {
        Ciudad ciudad=mc.toEntity(dtoCiudad);
        ciudad=rc.save(ciudad);
        return mc.toDto(ciudad);
    }

    @Override
    public DtoCiudad updateCiudad(Long id, DtoCiudad dtoCiudad) {
        Optional<Ciudad> optionalCiudad=rc.findById(id);
        if(optionalCiudad.isPresent()){
            Ciudad ciudad=optionalCiudad.get();
            ciudad.setNombre(dtoCiudad.getNombre());
            
            ciudad=rc.save(ciudad);
            return mc.toDto(ciudad);
        }
        return null;
    }

    @Override
    public void deleteCiudad(Long id) {
        Optional<Ciudad> optionalCiudad=rc.findById(id);
        
        if(optionalCiudad.isPresent()){
            Ciudad ciudad=optionalCiudad.get();
            
            rc.deleteById(id);
        }
    }

}
