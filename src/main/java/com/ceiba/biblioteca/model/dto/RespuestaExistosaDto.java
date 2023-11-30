package com.ceiba.biblioteca.model.dto;

import java.io.Serializable;

public class RespuestaExistosaDto implements Serializable {

    Long id;
    String fechaMaximaDevolucion;

    public RespuestaExistosaDto(Long id, String fechaMaximaDevolucion) {
        this.id = id;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }
}
