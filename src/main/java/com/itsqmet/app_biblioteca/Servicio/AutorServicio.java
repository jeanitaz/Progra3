package com.itsqmet.app_biblioteca.Servicio;

import com.itsqmet.app_biblioteca.Entidad.Autor;
import com.itsqmet.app_biblioteca.Entidad.Libro;
import com.itsqmet.app_biblioteca.Repositorio.AutorRepositorio;
import com.itsqmet.app_biblioteca.Repositorio.LibroRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio {
    @Autowired
    private AutorRepositorio autorRepositorio;

    //
    public List<Autor> buscarAutorPorNombre(String buscarAutor) {
        if (buscarAutor == null || buscarAutor.isEmpty()) {
            return autorRepositorio.findAll();
        } else {
            return autorRepositorio.findByNombreContainingIgnoreCase(buscarAutor);
        }
    }

    //Mostrar los Libros
    public List<Autor> mostrarAutores() {
        return autorRepositorio.findAll();
    }

    //Buscar LIbro por Id
    public Optional<Autor> buscarAutorPorId(Long id){
        return autorRepositorio.findById(id);
    }

    //Guardar Libro
    public Autor guardarAutor(Autor autor){
        return autorRepositorio.save(autor);
    }

    //Eliminar Libro
    public void eliminarAutor(Long id){
        autorRepositorio.deleteById(id);
    }

    //Obtener Autor por su Libro
    @Transactional
    public Autor obtenerAutorConLibros(Long id){
        Autor autor = autorRepositorio.findById(id).orElseThrow();
        return autor;
    }
}
