package com.itsqmet.app_biblioteca.Servicio;

import com.itsqmet.app_biblioteca.Entidad.Rol;
import com.itsqmet.app_biblioteca.Repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServicio {
    @Autowired
    private RolRepositorio rolRepositorio;

    public List<Rol> mostrarRoles() {
        return rolRepositorio.findAll();
    }
}