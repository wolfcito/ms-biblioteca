package com.ceiba.biblioteca.model.dto;

import java.io.Serializable;

public class MensajeDto implements Serializable {
    String mensaje;

    public MensajeDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
