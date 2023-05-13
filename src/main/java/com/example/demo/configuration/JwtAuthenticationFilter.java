/*package com.example.demo.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.model.Usuarios;
import com.example.demo.services.UsuarioServices;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//se obtiene el token de la solicitud HTTP//
		String token = obtenerJWTSolicitud(request);
		try {
			//valido el token//
			if(StringUtils.hasText(token) && jwtTokenProvider.validarToken(token)) {
				String Username = jwtTokenProvider.obtenerUsuarioJWT(token);
				
				//cargamos el usuario//
				UserDetails usuarioToken = userDetailsService.loadUserByUsername(Username);
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuarioToken,null);
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
			
			filterChain.doFilter(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	private String obtenerJWTSolicitud(HttpServletRequest request) {
		
		String bearerToken = request.getHeader("Authorization");
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("bearer")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
		
	}

}
*/