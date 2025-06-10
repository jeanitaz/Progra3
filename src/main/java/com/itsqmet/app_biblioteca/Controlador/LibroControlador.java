package com.itsqmet.app_biblioteca.Controlador;

import com.itsqmet.app_biblioteca.Entidad.Autor;
import com.itsqmet.app_biblioteca.Entidad.Libro;
import com.itsqmet.app_biblioteca.Servicio.AutorServicio;
import com.itsqmet.app_biblioteca.Servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LibroControlador {
    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private AutorServicio autorServicio;

    //Leer
    @GetMapping("/libros")
    public String Listarlibros(@RequestParam(name = "buscarLibro", required = false, defaultValue = "")
                               String buscarLibro, Model model) {
        List<Libro> libros = libroServicio.buscarLibroPorTitulo(buscarLibro);
        model.addAttribute("buscarLibro", buscarLibro);
        model.addAttribute("libros", libros);
        return "Pages/Lista.Libros";
    }

    //Metodo Para Insertar Libros
    @GetMapping("/formularioLibro")
    public String formularioLibro(Model model) {
        model.addAttribute("libro", new Libro());
        // Pasar los autores desde el servicio autor al formulario
        List<Autor> autores = autorServicio.mostrarAutores();
        model.addAttribute("autores", autores);
        return "Pages/formularioLibro";
    }

    @PostMapping("/guardarLibro")
    public String crearLibro(Libro libro) {
        libroServicio.guardarLibro(libro);
        return "redirect:/libros";
    }

    //Actualizar Libro
    @GetMapping("editarLibro/{id}")
    public String actualizarLibro(@PathVariable Long id, Model model) {
        Optional<Libro> libro = libroServicio.buscarLibroPorId(id);

        //Pasar los autores desde el servicio autor al formulario
        List<Autor> autores = autorServicio.mostrarAutores();
        model.addAttribute("autores", autores);
        model.addAttribute( "libro", libro);
        return "Pages/formularioLibro";
    }

    //Eliminar Libro
    @GetMapping("eliminarLibro/{id}")
    public String eliminarLibro(@PathVariable Long id){
        libroServicio.eliminarLibro(id);
        return "redirect:/libros";
    }
}