package com.api.ong.demo.controller;

import com.api.ong.demo.dto.DtoPersona;
import com.api.ong.demo.exception.AprobacionAdmin;
import com.api.ong.demo.exception.ErrorGeneral;
import com.api.ong.demo.service.ServicePersona;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author perez
 */

@Tag(name = "Funcionalidad Api persona",
        description = "Este api server tiene toda la funcionalidad de persona")
@RestController
@RequestMapping(path="/persona")
public class ControllerPersona {
    
    @Autowired
    private ServicePersona sp;
    
    @Operation(description = "Aquí se registran las personas",
            summary ="retorna 204 si no se pudo registrar")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Exito"),
    @ApiResponse(responseCode = "500", description = "Internal error")})
    @PostMapping("/signup")
    public ResponseEntity<DtoPersona> registrarPersona(@RequestBody DtoPersona dtoP) throws ErrorGeneral{
        
        DtoPersona personaCreada=sp.signUp(dtoP);
        return new ResponseEntity<>(personaCreada,HttpStatus.OK);
        
    }
    
    @Operation(description = "Aquí ingresan las personas",
            summary ="retorna 204 si no se pudo ingresar")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Exito"),
    @ApiResponse(responseCode = "500", description = "datos incorrectos")})
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody(required=true) Map<String,String> requestMap){
        try{
            return sp.login(requestMap);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return new ResponseEntity<>("algo salió mal logueandose",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/listar_personas")
    public ResponseEntity<List<DtoPersona>> listarPacientes() throws AprobacionAdmin, ErrorGeneral{
        List<DtoPersona> dtoP=sp.getAllUsers();
        return new ResponseEntity<>(dtoP,HttpStatus.OK);
    }
    
    @PutMapping("/cambiar_estado/{id}")
    public ResponseEntity<DtoPersona> actualizarMedico
        (@PathVariable Long id,@RequestBody DtoPersona dtoP){
        
            DtoPersona updatePersonaStatus=sp.updatePersonaStatus(id, dtoP);
            
            if (updatePersonaStatus!=null) {
                return new ResponseEntity<>(updatePersonaStatus,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
    

}
