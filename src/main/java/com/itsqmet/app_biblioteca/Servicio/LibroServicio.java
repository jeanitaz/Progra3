package com.itsqmet.app_biblioteca.Servicio;

import com.itsqmet.app_biblioteca.Entidad.Libro;
import com.itsqmet.app_biblioteca.Repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepositorio;

    //Mostrar los Libros
    public List<Libro> mostraLibros() {
        return libroRepositorio.findAll();
    }

    //Buscar Libro Por El Titulo
    public List<Libro> buscarLibroPorTitulo(String buscarLibro){
        if (buscarLibro== null || buscarLibro.isEmpty()){
            return libroRepositorio.findAll();
        }else{
            return libroRepositorio.findByTituloContainingIgnoreCase(buscarLibro);
        }
    }
    //Buscar LIbro por Id
    public Optional<Libro> buscarLibroPorId(Long id){
        return libroRepositorio.findById(id);
    }

    //Guardar Libro
    public Libro guardarLibro(Libro libro){
       return libroRepositorio.save(libro);
    }

    //Eliminar Libro
    public void eliminarLibro(Long id){
        libroRepositorio.deleteById(id);
    }
}
