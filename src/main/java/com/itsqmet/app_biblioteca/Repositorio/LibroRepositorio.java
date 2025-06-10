package com.itsqmet.app_biblioteca.Repositorio;

import com.itsqmet.app_biblioteca.Entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepositorio extends JpaRepository <Libro, Long>{
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByAutorId(Long autor_id);
}
