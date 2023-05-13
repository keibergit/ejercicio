/*package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.AuthenticatedUser;
import com.example.demo.configuration.JwtTokenProvider;
import com.example.demo.model.Usuarios;



@EnableWebSecurity
@RestController
public class AuthController {

	@Autowired(required=false)
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;


	@PostMapping("/login")
	public ResponseEntity<AuthenticatedUser> authenticateUser(@RequestBody Usuarios usuario){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getPassword()));
		
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtTokenProvider.generarToken(authentication);
		
		return ResponseEntity.ok(new AuthenticatedUser(0, null, null, null, token, false));
		//return new ResponseEntity<>("Ha iniciado session con exito!",HttpStatus.OK);
		
	}
	

}*/
