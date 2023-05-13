package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Usuarios;

public interface UsuarioServices {
	
	Usuarios crearUsuario( Usuarios usuarios);
	
	List<Usuarios> getUsuarios();
	
	Usuarios obtenerUsuario(long id);
	
	Usuarios modificarUsuario(long id, Usuarios usuarioModificar);
	
	boolean borrarUsuario(long id);

	Usuarios buscarUsuario(String correo);
	

	

}
