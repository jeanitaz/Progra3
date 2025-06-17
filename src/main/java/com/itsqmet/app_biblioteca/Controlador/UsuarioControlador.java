
        package com.itsqmet.app_biblioteca.Controlador;

        import com.itsqmet.app_biblioteca.Entidad.Usuario;
        import com.itsqmet.app_biblioteca.Servicio.UsuarioServicio;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.util.List;
        import java.util.Optional;

        import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

        @Controller
        public class UsuarioControlador {
            @Autowired
            private UsuarioServicio usuarioServicio;

            // Leer usuarios
            @GetMapping("/usuarios")
            public String listarUsuarios(Model model) {
                List<Usuario> usuarios = usuarioServicio.mostrarUsuario();
                model.addAttribute("usuarios", usuarios);
                return "Pages/listaUsuarios";
            }

            // Formulario para crear usuario
            @GetMapping("/formularioUsuario")
            public String formularioUsuario(Model model) {
                model.addAttribute("usuario", new Usuario());
                return "Pages/FormularioUsuario";
            }

            // Guardar usuario
            @PostMapping("/guardarUsuario")
            public String crearUsuario(Usuario usuario) {
                usuarioServicio.guardarUsuario(usuario);
                return "redirect:/usuarios";
            }

            // Actualizar usuario
            @GetMapping("/editarUsuario/{id}")
            public String actualizarUsuario(@PathVariable Long id, Model model) {
                Optional<Usuario> usuario = usuarioServicio.buscarUsuarioPorId(id);
                usuario.ifPresent(u -> model.addAttribute("usuario", usuario));
                return "Pages/FormularioUsuario";
            }

            // Eliminar usuario
            @GetMapping("/eliminarUsuario/{id}")
            public String eliminarUsuario(@PathVariable Long id){
                usuarioServicio.eliminarUsuario(id);
                return "redirect:/usuarios";
            }
        }