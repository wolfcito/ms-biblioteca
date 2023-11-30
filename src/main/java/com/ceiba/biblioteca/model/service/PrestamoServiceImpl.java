package com.ceiba.biblioteca.model.service;

import com.ceiba.biblioteca.model.dao.PrestamoDao;
import com.ceiba.biblioteca.model.dto.PrestamoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrestamoServiceImpl implements IPrestamoService {

    @Autowired
    PrestamoDao prestamoDao;

    @Override
    public Optional<PrestamoDto> findById(Long id) {
        return prestamoDao.findById(id).map(PrestamoDto::new);

    }

    @Override
    public Optional<PrestamoDto> findByIdentificacionUsuario(String identificacionUsuario) {

        return prestamoDao.findFirstByIdentificacionUsuario(identificacionUsuario).map(PrestamoDto::new);

    }

    @Override
    public PrestamoDto save(PrestamoDto prestamo) {
        return new PrestamoDto(prestamoDao.save(PrestamoDto.toPrestamo(prestamo)));
    }

    @Override
    public Optional<PrestamoDto> findByIsbn(String isbn) {
        return prestamoDao.findFirstByIsbn(isbn).map(PrestamoDto::new);
    }
}
