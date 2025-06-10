package com.itsqmet.app_biblioteca.Controlador;

import com.itsqmet.app_biblioteca.Entidad.Autor;
import com.itsqmet.app_biblioteca.Entidad.Libro;
import com.itsqmet.app_biblioteca.Servicio.AutorServicio;
import com.itsqmet.app_biblioteca.Servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AutorControlador {
    @Autowired
    private AutorServicio autorServicio;

    @Autowired
    private LibroServicio libroServicio;

    //Leer
    @GetMapping("/autores")
    public String Listarlibros(@RequestParam(name = "buscarAutor", required = false, defaultValue = "")
                               String buscarAutor, Model model) {
        List<Autor> autores = autorServicio.buscarAutorPorNombre(buscarAutor);
        model.addAttribute("buscarLibro", buscarAutor);
        model.addAttribute("autores", autores);
        return "Pages/listaAutores";
    }

    //Metodo Para Insertar Libros
    @GetMapping("/formularioAutor")
    public String formularioAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "Pages/formularioAutor";
    }

    @PostMapping("/guardarAutor")
    public String crearAutor(Autor autor) {
        autorServicio.guardarAutor(autor);
        return "redirect:/autores";
    }

    //Actualizar Libro
    @GetMapping("editarAutor/{id}")
    public String actualizarLibro(@PathVariable Long id, Model model) {
        Optional<Autor> autor = autorServicio.buscarAutorPorId(id);
        model.addAttribute( "autor", autor);
        return "Pages/formularioAutor";
    }

    //Eliminar Libro
    @GetMapping("eliminarAutor/{id}")
    public String eliminarAutor(@PathVariable Long id){
        autorServicio.eliminarAutor(id);
        return "redirect:/autores";
    }

    //Metodo para obtener libro por autor
    @GetMapping("/librosAutor/{id}")
    public String obtenerLibrosPorAutor(@PathVariable Long id, Model model){
        Autor autor = autorServicio.obtenerAutorConLibros(id);
        List<Libro> librosAutor = libroServicio.buscarLibrosAutor(autor.getId());
        model.addAttribute("librosAutor", librosAutor);
        model.addAttribute("autor", autor);
        return "Pages/listaAutorLibro";
    }
}
