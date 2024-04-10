package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoAlimentos;
import com.api.ong.demo.dto.DtoEnvio;
import com.api.ong.demo.dto.DtoEnvioMaterial;
import com.api.ong.demo.models.Alimentos;
import com.api.ong.demo.models.Envio;
import com.api.ong.demo.models.EnvioMaterial;
import com.api.ong.demo.repository.RepositoryEnvio;
import com.api.ong.demo.repository.RepositoryEnvioMaterial;
import java.text.SimpleDateFormat;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author perez
 */
@Component
public class MapperAlimentos {

    @Autowired
    private RepositoryEnvioMaterial rem;
    
    @Autowired
    private RepositoryEnvio re;
    
    public DtoAlimentos toDto(Alimentos a) {
        DtoAlimentos dtoA = new DtoAlimentos();
        dtoA.setId(a.getId());
        dtoA.setNumero_toneladas(a.getNumero_toneladas());
        if (a.getEnvioMaterial() != null) {
            EnvioMaterial em=a.getEnvioMaterial();
            DtoEnvioMaterial dtoEM = new DtoEnvioMaterial();
            dtoEM.setId(em.getId());
            if (em.getEnvio() != null) {
                Envio e = em.getEnvio();
                DtoEnvio dtoE = new DtoEnvio();
                dtoE.setId(e.getId());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                String fechaFormateada = sdf.format(e.getFecha_salida());
                dtoE.setFecha_salida(fechaFormateada);

                dtoEM.setDtoEnvio(dtoE);
            }
            dtoA.setDtoEnvioMaterial(dtoEM);
        }
        return dtoA;
    }

    public Alimentos toEntity(DtoAlimentos dtoA) {
        
        Alimentos a=new Alimentos();
        
        a.setId(dtoA.getId());
        a.setNumero_toneladas(dtoA.getNumero_toneladas());
        
        Optional<EnvioMaterial> envioM=rem.findById(dtoA.getDtoEnvioMaterial().getId());
        EnvioMaterial envioBBDD=envioM.get();
        a.setEnvioMaterial(envioBBDD);
        return null;
    }
}
