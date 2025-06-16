package com.itsqmet.app_biblioteca.Controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itsqmet.app_biblioteca.Entidad.Autor;
import com.itsqmet.app_biblioteca.Entidad.Libro;
import com.itsqmet.app_biblioteca.Servicio.AutorServicio;
import com.itsqmet.app_biblioteca.Servicio.LibroServicio;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

        import java.io.IOException;
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

    @GetMapping("/libros/pdf")
    public void exportarPDF(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=libros.pdf");
        List<Libro> libros = libroServicio.mostraLibros();
        Document documento = new Document();
        PdfWriter.getInstance(documento, response.getOutputStream());
        documento.open();
        documento.add(new Paragraph("Lista de Libros"));
        documento.add(new Paragraph(" "));

        for (Libro libro : libros) {
            documento.add(new Paragraph("Titulo: " + libro.getTitulo()));
            documento.add(new Paragraph("Autor: " + libro.getAutor().getNombre()));
        }
        documento.close();
    }
}