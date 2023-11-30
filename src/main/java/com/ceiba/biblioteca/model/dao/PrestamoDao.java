package com.ceiba.biblioteca.model.dao;

import com.ceiba.biblioteca.model.Prestamo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PrestamoDao extends CrudRepository<Prestamo, Long> {

    Optional<Prestamo> findFirstByIdentificacionUsuario(String identificacionUsuario);

    Optional<Prestamo> findFirstByIsbn(String isbn);
}
