package com.itsqmet.app_biblioteca.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Prestamo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaPrestamo;
    private Date fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "codigo_libro")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "codigo_usuario")
    private Usuario usuario;
}
