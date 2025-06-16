package com.itsqmet.app_biblioteca.Servicio;


import com.itsqmet.app_biblioteca.Entidad.Usuario;
import com.itsqmet.app_biblioteca.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //Mostrar Usuario
    public List<Usuario> mostrarUsuario() {
        return usuarioRepositorio.findAll();
    }


    //Buscar Usuario por Id
    public Optional<Usuario> buscarUsuarioPorId(Long id){
        return usuarioRepositorio.findById(id);
    }

    //Guardar Usuario
    public Usuario guardarUsuario(Usuario usuario){
        String passwordEncriptado = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptado);
        return usuarioRepositorio.save(usuario);
    }

    //Eliminar Usuario
    public void eliminarUsuario(Long id){
        usuarioRepositorio.deleteById(id);
    }
}
