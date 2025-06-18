package com.itsqmet.app_biblioteca.Controlador;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControlador {
    @GetMapping("/login")
    public String login() {
        return "Pages/Login";
    }

    @GetMapping("/postLogin")
    public String RedirigirPorLogin(Authentication authentication) {
        // Aquí puedes manejar la lógica después de que el usuario se haya autenticado
        User usuario = (User) authentication.getPrincipal();
        String role = usuario.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .findFirst()
                .orElse("");
        if (role.equals("ROLE_ADMIN")) {
            return "redirect:/admin";
        } else if (role.equals("ROLE_BIBLIOTECARIO")) {
            return "redirect:/autores";
        } else if (role.equals("ROLE_ESTUDIANTE")) {
            return "redirect:/libros";
        } else {
            return "redirect:/login?error";
        }
    }
}

