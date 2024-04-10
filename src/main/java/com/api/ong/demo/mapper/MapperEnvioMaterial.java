package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoCiudad;
import com.api.ong.demo.dto.DtoEnvio;
import com.api.ong.demo.dto.DtoEnvioMaterial;
import com.api.ong.demo.dto.DtoRefugio;
import com.api.ong.demo.dto.DtoSede;
import com.api.ong.demo.models.Ciudad;
import com.api.ong.demo.models.Envio;
import com.api.ong.demo.models.EnvioMaterial;
import com.api.ong.demo.models.Refugio;
import com.api.ong.demo.models.Sede;
import com.api.ong.demo.repository.RepositoryEnvio;
import java.text.SimpleDateFormat;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author perez
 */

@Component
public class MapperEnvioMaterial {
    
    @Autowired
    private RepositoryEnvio re;
    
    //Pasamos datos entidad a dto
    public DtoEnvioMaterial toDto(EnvioMaterial em){
        DtoEnvioMaterial dtoEM=new DtoEnvioMaterial();
        dtoEM.setId(em.getId());
        if(em.getEnvio()!=null){
            Envio e = em.getEnvio();
            DtoEnvio dtoE = new DtoEnvio();
            dtoE.setId(e.getId());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String fechaFormateada = sdf.format(e.getFecha_salida());
            dtoE.setFecha_salida(fechaFormateada);

            if (e.getSede()!= null) {
                Sede s = e.getSede();
                DtoSede dtoS = new DtoSede();
                dtoS.setId(s.getId());
                if (s.getCiudad() != null) {
                    Ciudad c = s.getCiudad();
                    DtoCiudad dtoC = new DtoCiudad();
                    dtoC.setId(c.getId());
                    dtoC.setNombre(c.getNombre());
                    dtoS.setCiudad(dtoC);
                }
                dtoE.setDtoSede(dtoS);
            }

            if (e.getRefugio()!= null) {
                Refugio r = e.getRefugio();
                DtoRefugio dtoR = new DtoRefugio();
                dtoR.setId(r.getId());
                dtoR.setUbicacion(r.getUbicacion());
                if (r.getCiudad() != null) {
                    Ciudad c = r.getCiudad();
                    DtoCiudad dtoC = new DtoCiudad();
                    dtoC.setId(c.getId());
                    dtoC.setNombre(c.getNombre());
                    dtoR.setDtoCiudad(dtoC);
                }
                dtoE.setDtorefugio(dtoR);
            }
            dtoEM.setDtoEnvio(dtoE);
        }
        return dtoEM;
    }
    
    //Pasamos datos dto a entidad
    public EnvioMaterial toEntity(DtoEnvioMaterial dtoEM){
        EnvioMaterial em=new EnvioMaterial();
        em.setId(dtoEM.getId());
        
        Optional<Envio> envio=re.findById(dtoEM.getDtoEnvio().getId());
        Envio envioBBDD=envio.get();
        em.setEnvio(envioBBDD);
        return null;
    }
}
