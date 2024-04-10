package com.api.ong.demo.controller;

import com.api.ong.demo.dto.DtoDirector;
import com.api.ong.demo.service.ServiceDirector;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author perez
 */
@RestController
@RequestMapping(path="/director")
public class ControllerDirector {
    
    @Autowired
    private ServiceDirector sd;
    
    @GetMapping
    public ResponseEntity<List<DtoDirector>> listarDirectores(){
        List<DtoDirector> directores=sd.getAllDirector();
        return new ResponseEntity<>(directores,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DtoDirector> obtenerDirector(@PathVariable Long id){
        Optional<DtoDirector> director=sd.getDirectorById(id);
        return director.map(dto->new ResponseEntity<>(dto,HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<DtoDirector> guardarDirector(@RequestParam Long personaId,
            @RequestBody DtoDirector dtoD) throws ParseException{
        DtoDirector createdConsulta=sd.createDirector(personaId, dtoD);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConsulta);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DtoDirector> actualizarDirector(@PathVariable Long id,
            @RequestBody DtoDirector consultaDto) throws ParseException{
        DtoDirector updateDirector=sd.updateDirector(id, consultaDto);
        return updateDirector!=null
                ? new ResponseEntity<>(updateDirector,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDirector(@PathVariable Long id){
        sd.deleteDirector(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
