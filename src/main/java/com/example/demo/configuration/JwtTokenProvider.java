package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;

//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.demo.model.Usuarios;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
	
	@Value("${app.jwt-secret}")
	private String jwtSecret;
	
	@Value("${app.jwt-expiration-milliseconds}")
	private int jwtExpirationInms;
	
	public String generarToken(Usuarios usuarios) {
		String userName = usuarios.getName();
		Date fechaActual = new Date();
		Date fechaExpiracion = new Date(fechaActual.getTime() + jwtExpirationInms);
		
		String token = Jwts.builder().setSubject(userName).setIssuedAt(new Date()).setExpiration(fechaExpiracion)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		
		return token;
	}
	
	public String obtenerUsuarioJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
	
	public boolean validarToken(String token) throws Exception {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		}catch(SignatureException ex) {
			throw new Exception("Firma JWT no valido");
			
		}catch(MalformedJwtException ex) {
			throw new Exception("Token no valido");
			
		}catch(ExpiredJwtException ex) {
			throw new Exception("Token Caducado");
			
		}catch(UnsupportedJwtException ex) {
			throw new Exception("Token no compatible");
		
		}

	}
}
