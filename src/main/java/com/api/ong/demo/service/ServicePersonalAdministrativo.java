package com.api.ong.demo.service;

import com.api.ong.demo.dto.DtoPersonalAdministrativo;
import com.api.ong.demo.dto.DtoPersonalSanitario;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author perez
 */
public interface ServicePersonalAdministrativo {

    List<DtoPersonalAdministrativo> getAllPersonalAdministrativo();
    
    Optional<DtoPersonalAdministrativo> getPersonalAdministrativoById(Long id);
    
    DtoPersonalAdministrativo createPersonalAdministrativo(Long voluntarioId,DtoPersonalAdministrativo dtoPersonal) throws ParseException;
    
    DtoPersonalAdministrativo updatePersonalAdministrativo(Long id, DtoPersonalAdministrativo dtoPersonal) throws ParseException;
    
    void deletePersonalAdministrativo(Long id);
    
}
