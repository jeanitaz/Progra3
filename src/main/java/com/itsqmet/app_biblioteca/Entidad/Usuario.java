package com.itsqmet.app_biblioteca.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String email;
    private String username;
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamos;

    //Relacion con suscripcion
    @OneToOne(mappedBy = "usuario")
    private Suscrpcion suscripcion;

    /*@ManyToMany
    @JoinTable(name="prestamo",
    joinColumns = @JoinColumn(name = "codigo_usuario"),
            inverseJoinColumns = @JoinColumn(name = "codigo_libro"))
    private List<Libro> libros;*/

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
