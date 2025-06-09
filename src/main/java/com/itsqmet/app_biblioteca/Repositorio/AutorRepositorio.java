package com.itsqmet.app_biblioteca.Repositorio;

import com.itsqmet.app_biblioteca.Entidad.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepositorio extends JpaRepository <Autor, Long> {
    List<Autor> findByNombreContainingIgnoreCase(String nombre);
}

