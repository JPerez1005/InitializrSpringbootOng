package com.api.ong.demo.repository;

import com.api.ong.demo.models.PersonalSanitario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author perez
 */
@Repository
public interface RepositoryPersonalSanitario extends JpaRepository<PersonalSanitario, Long>{

}
