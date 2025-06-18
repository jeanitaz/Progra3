package com.itsqmet.app_biblioteca.Repositorio;

import com.itsqmet.app_biblioteca.Entidad.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<Rol,Long > {
}
