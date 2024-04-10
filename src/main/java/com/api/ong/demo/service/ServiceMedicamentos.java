package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoAlimentos;
import com.api.ong.demo.dto.DtoMedicamentos;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServiceMedicamentos {

    List<DtoMedicamentos> getAllMedicamento();
    
    Optional<DtoMedicamentos> getMedicamentoById(Long id);
    
    DtoMedicamentos createMedicamento(Long envioId,DtoMedicamentos dtoMedicamentos) throws ParseException;
    
    DtoMedicamentos updateMedicamento(Long id,DtoMedicamentos dtoMedicamentos) throws ParseException;
    
    void deleteMedicamento(Long id);
    
}
