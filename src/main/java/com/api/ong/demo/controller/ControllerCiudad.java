package com.api.ong.demo.controller;

import com.api.ong.demo.dto.DtoCiudad;
import com.api.ong.demo.dto.DtoDirector;
import com.api.ong.demo.service.ServiceCiudad;
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
@RequestMapping(path="/ciudad")
public class ControllerCiudad {

    @Autowired
    private ServiceCiudad sc;
    
    @GetMapping
    public ResponseEntity<List<DtoCiudad>> listarCiudades(){
        List<DtoCiudad> ciudades=sc.getAllCiudades();
        return new ResponseEntity<>(ciudades,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DtoCiudad> obtenerCiudades(@PathVariable Long id){
        Optional<DtoCiudad> ciudad=sc.getCiudadById(id);
        return ciudad.map(dto->new ResponseEntity<>(dto,HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<DtoCiudad> guardarCiudad(@RequestBody DtoCiudad dtoC) throws ParseException{
        DtoCiudad createdCiudad=sc.createCiudad(dtoC);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCiudad);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DtoCiudad> actualizarCiudad(@PathVariable Long id,
            @RequestBody DtoCiudad consultaDto) throws ParseException{
        DtoCiudad updateCiudad=sc.updateCiudad(id, consultaDto);
        return updateCiudad!=null
                ? new ResponseEntity<>(updateCiudad,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDirector(@PathVariable Long id){
        sc.deleteCiudad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
