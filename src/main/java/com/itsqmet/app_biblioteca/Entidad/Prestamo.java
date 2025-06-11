package com.itsqmet.app_biblioteca.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Prestamo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPrestamo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "codigo_libro")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "codigo_usuario")
    private Usuario usuario;
}
