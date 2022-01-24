package com.ceiba.biblioteca.model.service;

import com.ceiba.biblioteca.model.dto.PrestamoDto;

import java.util.Optional;

public interface IPrestamoService {

    public Optional<PrestamoDto> findById(Long id);

    public Optional<PrestamoDto> findByIdentificacionUsuario(String identificacionUsuario);

    public PrestamoDto save(PrestamoDto prestamoDto);

    public Optional<PrestamoDto> findByIsbn(String isbn);
}
