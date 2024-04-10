package com.api.ong.demo.service.impl;

import com.api.ong.demo.dto.DtoSede;
import com.api.ong.demo.service.ServiceSede;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * @author perez
 */

@Service
public class ServiceImplSede implements ServiceSede{

    @Override
    public List<DtoSede> getAllSedes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<DtoSede> getSedeById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DtoSede createSede(Long ciudadId, Long directorId, DtoSede dtoSede) throws ParseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DtoSede updateSede(Long id, DtoSede dtoSede) throws ParseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteSede(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
