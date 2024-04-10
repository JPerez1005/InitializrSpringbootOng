package com.api.ong.demo.repository;

import com.api.ong.demo.models.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author perez
 */
@Repository
public interface RepositorySede extends JpaRepository<Sede, Long>{

}
