package com.api.ong.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author perez
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="voluntario")
public class Voluntario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Sede sede;
    
    @OneToOne
    private Persona persona;
    
    @OneToMany(mappedBy = "voluntario", fetch=FetchType.LAZY)
    private Collection<PersonalAdministrativo> administrativo;
    
    @OneToMany(mappedBy = "voluntario", fetch=FetchType.LAZY)
    private Collection<PersonalSanitario> sanitario;
    
}
