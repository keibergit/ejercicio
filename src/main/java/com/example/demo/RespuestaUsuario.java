package com.example.demo;

import com.example.demo.model.Usuarios;

public class RespuestaUsuario {
	
    private Usuarios usuario;
    private String mensaje;

    public RespuestaUsuario(Usuarios usuario, String mensaje) {
        this.usuario = usuario;
        this.mensaje = mensaje;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

