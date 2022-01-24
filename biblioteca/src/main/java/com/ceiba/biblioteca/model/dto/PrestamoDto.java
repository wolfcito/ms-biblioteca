package com.ceiba.biblioteca.model.dto;


import com.ceiba.biblioteca.model.Prestamo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrestamoDto implements Serializable {

    Long id;
    String isbn;
    String identificacionUsuario;
    Integer tipoUsuario;
    String fechaMaximaDevolucion;

    public PrestamoDto(String isbn, String identificacionUsuario, Integer tipoUsuario) {
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
    }


    public PrestamoDto(Prestamo prestamo) {
        this.id = prestamo.getId();
        this.isbn = prestamo.getIsbn();
        this.identificacionUsuario = prestamo.getIdentificacionUsuario();
        this.tipoUsuario = prestamo.getTipoUsuario();
        this.fechaMaximaDevolucion = prestamo.getFechaMaximaDevolucion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static Prestamo toPrestamo(PrestamoDto prestamoDto) {
        Prestamo prestamo = new Prestamo();
        prestamo.setId(prestamoDto.getId());
        prestamo.setIsbn(prestamoDto.getIsbn());
        prestamo.setTipoUsuario(prestamoDto.getTipoUsuario());
        prestamo.setIdentificacionUsuario(prestamoDto.getIdentificacionUsuario());
        prestamo.setFechaMaximaDevolucion(LocalDate.parse(prestamoDto.getFechaMaximaDevolucion(),DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        return prestamo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public void setLDFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
