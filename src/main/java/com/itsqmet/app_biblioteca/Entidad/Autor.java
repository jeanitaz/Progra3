package com.itsqmet.app_biblioteca.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String nacionalidad;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;
}
