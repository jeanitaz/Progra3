package com.itsqmet.app_biblioteca.Entidad;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    //Relacion con libros
    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY)
    private List<Libro> libros;
}
