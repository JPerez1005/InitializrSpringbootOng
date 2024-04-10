package com.api.ong.demo.repository;

import com.api.ong.demo.models.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author perez
 */
@Repository
public interface RepositoryEnvio extends JpaRepository<Envio, Long>{

}
