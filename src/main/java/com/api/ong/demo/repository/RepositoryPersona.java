package com.api.ong.demo.repository;

import com.api.ong.demo.dto.DtoPersona;
import com.api.ong.demo.models.Persona;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author perez
 */
@Repository
public interface RepositoryPersona extends JpaRepository<Persona, Long>{

    Persona findByEmail(@Param(("email")) String email);
    
//    List<DtoPersona> getAllUsers();
//    
//    List<String> getAllAdmins();
//    
//    @Transactional
//    @Modifying
//    Integer updateStatus(@Param("status") String status, @Param("id") Integer id);
}
