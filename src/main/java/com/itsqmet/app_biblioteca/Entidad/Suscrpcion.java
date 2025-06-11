package com.itsqmet.app_biblioteca.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Suscrpcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    private String tipo;

    @OneToOne
    @JoinColumn(name = "codigo_usuario", unique = true)
    private Usuario usuario;
}
