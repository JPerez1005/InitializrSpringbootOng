package com.api.ong.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="sede")
public class Sede {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "sede", fetch=FetchType.LAZY)
    private Collection<Socio> socios;
    
    @OneToMany(mappedBy = "sede", fetch=FetchType.LAZY)
    private Collection<Voluntario> voluntarios;
    
    @OneToMany(mappedBy = "sede", fetch=FetchType.LAZY)
    private Collection<Envio> envios;
    
    @OneToOne
    private Director director;
    
    @OneToOne
    private Ciudad ciudad;
    
    
}
