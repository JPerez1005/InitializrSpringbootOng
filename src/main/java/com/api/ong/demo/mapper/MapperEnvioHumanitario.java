package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoCiudad;
import com.api.ong.demo.dto.DtoEnvio;
import com.api.ong.demo.dto.DtoEnvioHumanitario;
import com.api.ong.demo.dto.DtoRefugio;
import com.api.ong.demo.dto.DtoSede;
import com.api.ong.demo.models.Ciudad;
import com.api.ong.demo.models.Envio;
import com.api.ong.demo.models.EnvioHumanitario;
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
public class MapperEnvioHumanitario {

    @Autowired
    private RepositoryEnvio re;
    
    //Pasamos datos entidad a dto
    public DtoEnvioHumanitario toDto(EnvioHumanitario eh) {
        DtoEnvioHumanitario dtoEH = new DtoEnvioHumanitario();
        dtoEH.setId(eh.getId());
        dtoEH.setNumero_voluntarios(eh.getNumero_voluntarios());
        if (eh.getEnvio() != null) {
            Envio e = eh.getEnvio();
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
            dtoEH.setDtoEnvio(dtoE);
        }
        return dtoEH;
    }

    //Pasamos datos dto a entidad
    public EnvioHumanitario toEntity(DtoEnvioHumanitario dtoEH) {
        EnvioHumanitario eh=new EnvioHumanitario();
        eh.setId(dtoEH.getId());
        eh.setNumero_voluntarios(dtoEH.getNumero_voluntarios());
        
        Optional<Envio> envio=re.findById(dtoEH.getDtoEnvio().getId());
        Envio envioBBDD=envio.get();
        eh.setEnvio(envioBBDD);
        return eh;
    }
}
