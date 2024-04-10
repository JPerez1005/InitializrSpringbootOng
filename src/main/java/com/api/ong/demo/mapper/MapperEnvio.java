package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoCiudad;
import com.api.ong.demo.dto.DtoEnvio;
import com.api.ong.demo.dto.DtoRefugio;
import com.api.ong.demo.dto.DtoSede;
import com.api.ong.demo.models.Ciudad;
import com.api.ong.demo.models.Director;
import com.api.ong.demo.models.Envio;
import com.api.ong.demo.models.Refugio;
import com.api.ong.demo.models.Sede;
import com.api.ong.demo.repository.RepositoryRefugio;
import com.api.ong.demo.repository.RepositorySede;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author perez
 */
@Component
public class MapperEnvio {
    
    @Autowired
    private RepositoryRefugio rr;
    
    @Autowired
    private RepositorySede rs;
    
    public DtoEnvio toDto(Envio e){
        DtoEnvio dtoE=new DtoEnvio();
        dtoE.setId(e.getId());
        
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String fechaFormateada=sdf.format(e.getFecha_salida());
        dtoE.setFecha_salida(fechaFormateada);
        
        if(e.getSede()!=null){
            Sede s=e.getSede();
            DtoSede dtoS=new DtoSede();
            
            dtoS.setId(s.getId());
            if(s.getCiudad()!=null){
                Ciudad c=s.getCiudad();
                DtoCiudad dtoC=new DtoCiudad();
                
                dtoC.setId(c.getId());
                dtoC.setNombre(c.getNombre());
                dtoS.setCiudad(dtoC);
            }
            
            dtoE.setDtoSede(dtoS);
        }
        
        if(e.getRefugio()!=null){
            Refugio r=e.getRefugio();
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
            dtoE.setDtorefugio(dtoR);
        }
        
        return dtoE;
    }
    
    public Envio toEntity(DtoEnvio dtoE) throws ParseException{
        Envio e=new Envio();
        e.setId(dtoE.getId());
        
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date fecha=sdf.parse(dtoE.getFecha_salida());
        e.setFecha_salida(fecha);
        
        Optional<Sede> sede=rs.findById(dtoE.getDtoSede().getId());
        Sede directorBBDD=sede.get();
        e.setSede(directorBBDD);
        
        Optional<Refugio> refugio=rr.findById(dtoE.getDtorefugio().getId());
        Refugio refugioBBDD=refugio.get();
        e.setRefugio(refugioBBDD);
        
        return e;
    }
}
