package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.AuthenticatedUser;
import com.example.demo.configuration.JwtTokenProvider;
import com.example.demo.exception.errorCorreo;
import com.example.demo.model.Usuarios;
import com.example.demo.services.UsuarioServices;
import com.example.demo.validator.usuarioValidarImpl;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioServices usuarioServices;
	
	@Autowired
	private usuarioValidarImpl valida;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/user")
	public ResponseEntity<AuthenticatedUser> crearUsario(@RequestBody Usuarios usuarios) throws errorCorreo{
		
	//valida los campos que envia el usuario//
		this.valida.validator(usuarios);
		
		Usuarios usuarioEncontrado = usuarioServices.buscarUsuario(usuarios.getEmail());
		
		if(usuarioEncontrado == null) {
			Usuarios userNew = usuarioServices.crearUsuario(usuarios);
			String token = jwtTokenProvider.generarToken(usuarios);
	
		    String mensaje = "El usuario ha sido creado";
		    return ResponseEntity.ok(new AuthenticatedUser(mensaje,usuarios.getId(), token, usuarios.getCreatedAt(), usuarios.getLastLogin(), usuarios.getUpdatedAt(), usuarios.isIsactive()));
		}
		
		else {
			
	        String mensaje = "El usuario ya existe";
	       return ResponseEntity.badRequest().body(new AuthenticatedUser(mensaje,0, null, null, null, null, false));
			
		}
	
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuarios>> getUsuarios(){
		return ResponseEntity.ok().body(usuarioServices.getUsuarios());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Usuarios> obtenerUsuario(@PathVariable long id){
		
		Usuarios user = usuarioServices.obtenerUsuario(id);
		
		return new ResponseEntity<Usuarios>(user, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus  borrarUsuario(@PathVariable long id){
		boolean eliminado = this.usuarioServices.borrarUsuario(id);
		if(eliminado == true) {
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Usuarios> modificarUsuario(@PathVariable long id, @RequestBody Usuarios usuario){
		
		Usuarios userUpdate = usuarioServices.modificarUsuario(id, usuario);
		
		return new ResponseEntity<Usuarios>(userUpdate, HttpStatus.OK);
		
	}

}
