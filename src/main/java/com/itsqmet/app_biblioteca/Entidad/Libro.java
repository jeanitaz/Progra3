package com.itsqmet.app_biblioteca.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="libros")



public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    private String editorial;
    private int paginas;
    private Double precio;

    @ManyToOne
    @JoinColumn(name= "codigo_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name= "codigo_genero")
    private Genero genero;

    @OneToMany
    @JoinColumn(name = "codigo_libro")
    private List<Prestamo> prestamos;


    /*@ManyToMany(mappedBy = "libros")
    private List<Usuario> usuarios;*/

}
