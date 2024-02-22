package com.jwt.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "contactos")
@Data
@Getter
@Setter
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContacto")
    private Integer id;

    private String nombre;

    @Column(name = "fechaCreacion")
    private LocalDate fechaCreacion;

    private String telefono;

    private String email;
}
