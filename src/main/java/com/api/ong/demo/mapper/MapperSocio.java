package com.api.ong.demo.mapper;

import com.api.ong.demo.dto.DtoPersona;
import com.api.ong.demo.dto.DtoSocio;
import com.api.ong.demo.dto.DtoVoluntario;
import com.api.ong.demo.models.Director;
import com.api.ong.demo.models.Persona;
import com.api.ong.demo.models.Sede;
import com.api.ong.demo.models.Socio;
import com.api.ong.demo.models.Voluntario;
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
public class MapperSocio {

    @Autowired
    private RepositorySede rs;
    
    public DtoSocio toDto(Socio s){
        DtoSocio dtoS=new DtoSocio();
        dtoS.setId(s.getId());
        dtoS.setSedeId(s.getSede().getId());
        dtoS.setCuenta_bancaria(s.getCuenta_bancaria());
        dtoS.setTipo_cuota(s.getTipo_cuota());
        
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String fechaFormateada=sdf.format(s.getFecha_pago());
        dtoS.setFecha_pago(fechaFormateada);
        
        if(s.getPersona()!=null){
            Persona p=s.getPersona();
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
            
            dtoS.setDtoPersona(dtoP);
        }
        return dtoS;
    }
    
    
    public Socio toEntity(DtoSocio dtoS) throws ParseException{
        Socio s=new Socio();
        s.setId(dtoS.getId());
        s.setCuenta_bancaria(dtoS.getCuenta_bancaria());
        s.setTipo_cuota(dtoS.getTipo_cuota());
        
        Optional<Sede> sede=rs.findById(dtoS.getSedeId());
        Sede sedeBBDD=sede.get();
        s.setSede(sedeBBDD);
        
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date fecha=sdf.parse(dtoS.getFecha_pago());
        s.setFecha_pago(fecha);
        
        if(dtoS.getDtoPersona()!=null){
            /*los datos del dto director los pasamos a la dto de persona*/
            DtoPersona dtoP=dtoS.getDtoPersona();
            Persona p=new Persona();//nueva persona
            p.setId(dtoP.getId());//mandamos el id que teniamos en dtopersona
            s.setPersona(p);//mandamos ese id a esa entidad
        }
        return s;
    }
    
}
