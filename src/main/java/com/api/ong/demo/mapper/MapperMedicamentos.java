package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoEnvio;
import com.api.ong.demo.dto.DtoEnvioMaterial;
import com.api.ong.demo.dto.DtoMedicamentos;
import com.api.ong.demo.models.Envio;
import com.api.ong.demo.models.EnvioMaterial;
import com.api.ong.demo.models.Medicamentos;
import com.api.ong.demo.repository.RepositoryEnvioMaterial;
import java.text.SimpleDateFormat;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author perez
 */

@Component
public class MapperMedicamentos {
    @Autowired
    private RepositoryEnvioMaterial rem;
    
    //Pasamos datos entidad a dto
    public DtoMedicamentos toDto(Medicamentos m){
        DtoMedicamentos dtoM=new DtoMedicamentos();
        dtoM.setId(m.getId());
        dtoM.setUnidades(m.getUnidades());
        if (m.getEnvioMaterial() != null) {
            EnvioMaterial em=m.getEnvioMaterial();
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
            dtoM.setDtoEnvioMaterial(dtoEM);
        }
        return dtoM;
    }
    
    //Pasamos datos dto a entidad
    public Medicamentos toEntity(DtoMedicamentos dtoM){
        Medicamentos m=new Medicamentos();
        m.setId(dtoM.getId());
        m.setUnidades(dtoM.getUnidades());
        
        Optional<EnvioMaterial> envioM=rem.findById(dtoM.getDtoEnvioMaterial().getId());
        EnvioMaterial envioBBDD=envioM.get();
        m.setEnvioMaterial(envioBBDD);
        return null;
    }
}
