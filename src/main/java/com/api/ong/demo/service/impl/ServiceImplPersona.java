package com.api.ong.demo.service.impl;

import com.api.ong.demo.dto.DtoPersona;
import com.api.ong.demo.exception.AprobacionAdmin;
import com.api.ong.demo.exception.ErrorGeneral;
import com.api.ong.demo.exception.ErrorValidacion;
import com.api.ong.demo.mapper.MapperPersona;
import com.api.ong.demo.models.Persona;
import com.api.ong.demo.repository.RepositoryPersona;
import com.api.ong.demo.security.CustomerDetailsService;
import com.api.ong.demo.security.jwt.JwtFilter;
import com.api.ong.demo.security.jwt.JwtUtil;
import com.api.ong.demo.service.ServicePersona;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author perez
 */

@Service
public class ServiceImplPersona implements ServicePersona {
    
    @Autowired
    private RepositoryPersona rp;
    
    @Autowired
    private MapperPersona mp;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private CustomerDetailsService detallesPersona;//detalles de usuario
    
    @Autowired
    private JwtUtil jwtUtil;//crear token,firmarlo,extraerdatos del token,validacion
    
    @Autowired
    private JwtFilter jwtFilter;
    
    @Override
    public DtoPersona signUp(DtoPersona dtoP) throws ErrorGeneral{
        /*buscamos el usuario*/
        Persona p=rp.findByEmail(dtoP.getEmail());
        if(Objects.isNull(p)){/*si retorna nulo el usuario no existe*/
            p=mp.toEntity(dtoP);
            p=rp.save(p);
            return mp.toDto(p);
        }else{
            //el usuario ya existe
            JOptionPane.showMessageDialog(null, "El usuario ya existe");
            ErrorGeneral exception=new ErrorGeneral("","Datos existentes",HttpStatus.PRECONDITION_FAILED);
            throw exception;
        }
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) throws AprobacionAdmin,ErrorValidacion{
        try {
            Authentication authentication=authenticationManager.authenticate(
                /*autenticamos los datos que nos entregan*/
                new UsernamePasswordAuthenticationToken(requestMap.get("email"),requestMap.get("password"))
            );
            //si se está autenticado...
            if (authentication.isAuthenticated()) {
                if(detallesPersona.getPersonaDetail().getStatus().equalsIgnoreCase("true")){
                    return new ResponseEntity<String>
                        ("{\"token\":\""+jwtUtil.generateToken
                            (detallesPersona.getPersonaDetail().getEmail(),
                            detallesPersona.getPersonaDetail().getRol())
                            +"\"}",HttpStatus.OK);
                }else{
                    AprobacionAdmin exception=new AprobacionAdmin("","{\"mensaje\":\""
                            +"Espere la Aprobación del admin"+"\"}",HttpStatus.BAD_REQUEST);
                    throw exception;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ErrorValidacion exception=new ErrorValidacion("","{\"mensaje\":\""+"Credenciales Incorrectas"+"\"}"
                ,HttpStatus.BAD_REQUEST);
                    throw exception;
    }

    @Override
    public List<DtoPersona> getAllUsers() throws AprobacionAdmin,ErrorGeneral{
        
        if (jwtFilter.isAdmin()) {//si es admin retornan la lista
            List<Persona> pacientes=rp.findAll();
            return pacientes.stream()
                    .map(mp::toDto)
                    .collect(Collectors.toList());
        }
        else if(!jwtFilter.isAdmin()){//si no pues no
            AprobacionAdmin exception=new AprobacionAdmin("","{\"mensaje\":\""
                            +"Espere la Aprobación del admin"+"\"}",HttpStatus.BAD_REQUEST);
                    throw exception;
        }
        else{
            ErrorGeneral exception=new ErrorGeneral("","{\"mensaje\":\""+"Algo salió mal"+"\"}"
                ,HttpStatus.BAD_REQUEST);
                    throw exception;
        }
        
    }

    @Override
    public DtoPersona updatePersonaStatus(Long id, DtoPersona dtoP) {
        Optional<Persona> optionalPersona=rp.findById(id);
        if(optionalPersona.isPresent()){
            Persona p=optionalPersona.get();
            p.setStatus(dtoP.getStatus());
            p=rp.save(p);
            return mp.toDto(p);
        }
        System.out.println("no se encontró el usuario");
        return null;
    }
    
    
    @Override
    public ResponseEntity<String> validarToken() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<String> cambiarContraseña(Map<String, String> requestMap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<String> forgotPassword(Map<String, String> requestMap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<DtoPersona> getPersonaById(Long id) {
        Optional<Persona> personaOptional=rp.findById(id);
        return personaOptional.map(mp::toDto);
    }

}
