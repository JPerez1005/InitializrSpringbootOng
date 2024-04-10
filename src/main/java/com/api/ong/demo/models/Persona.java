package com.api.ong.demo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author perez
 */

@NamedQuery(name="Persona.findByEmail",query="select p from Persona p where p.email=:email")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate//solo actualiza las columnas que cambiaron
@DynamicInsert//solo inserta las columnas que no son nulas
@Table(name="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Schema(name="primer_nombre",
            required=true,
            example="Julián",
            defaultValue = "no tiene",
            description = "es parte del nombre de la persona")
    private String primer_nombre;
    
    @Schema(name="segundo_nombre",
            required=false,
            example="David",
            defaultValue = "no tiene",
            description = "es parte del nombre de la persona")
    private String segundo_nombre;
    
    @Schema(name="primer_apellido",
            required=true,
            example="Perez",
            defaultValue = "no tiene",
            description = "es parte del apellido de la persona")
    private String primer_apellido;
    
    @Schema(name="segundo_apellido",
            required=false,
            example="Bueno",
            defaultValue = "no tiene",
            description = "es parte del apellido de la persona")
    private String segundo_apellido;
    
    @Schema(name="numero_identificacion",
            required=true,
            example="1005324417",
            defaultValue = "no tiene",
            description = "toda persona se identifica con esto en la sociedad")
    private String numero_identificacion;
    
    @Schema(name="telefono",
            required=false,
            example="3158163844",
            defaultValue = "no tiene",
            description = "es necesario para comunicarse")
    private String telefono;
    
    @Schema(name="rol",
            required=false,
            example="admin",
            defaultValue = "user",
            description = "debe tener para poder ingresar al sistema")
    private String rol;
    
    @Schema(name="email",
            required=true,
            example="jdpb@gmail.com",
            defaultValue = "noTiene@gmail.com",
            description = "debe tener para poder ingresar al sistema")
    private String email;
    
    @Schema(name="password",
            required=true,
            example="privado123",
            defaultValue = "privado123",
            description = "debe tener para poder ingresar al sistema")
    private String password;
    
    @Schema(name="status",
            required=false,
            example="activo",
            defaultValue = "activo",
            description = "se verifica si está activo o inactivo")
    private String status;
    
    @OneToOne(mappedBy = "persona")
    private Director director;
    
    @OneToOne(mappedBy = "persona")
    private Socio socio;
    
    @OneToOne(mappedBy = "persona")
    private Voluntario voluntario;
}
