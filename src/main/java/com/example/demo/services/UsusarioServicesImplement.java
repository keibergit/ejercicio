package com.example.demo.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuarioRepository;


@Service
@Transactional
public class UsusarioServicesImplement implements UsuarioServices{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuarios crearUsuario(Usuarios usuarios) {
		return usuarioRepository.save(usuarios);	
	}
	
	@Override
	public Usuarios modificarUsuario(long id, Usuarios usuarioModificar) {
		Usuarios usurioEncontrado = usuarioRepository.findById(id).get();
		usurioEncontrado.setName(usuarioModificar.getName());
		usurioEncontrado.setPhoned(usuarioModificar.getPhoned());
		usurioEncontrado.setIsactive(usuarioModificar.isIsactive());
		return usuarioRepository.save(usurioEncontrado);
	}
	
	@Override
	public Usuarios obtenerUsuario(long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> {throw new RuntimeException();});
	}

	@Override
	public List<Usuarios> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public boolean borrarUsuario(long usuarioId) {
		try {
			usuarioRepository.deleteById(usuarioId);
			return true;
			
		}catch(Exception e){
			return false;
			
		}
		
	}

	public Usuarios buscarUsuario(String correo) {
		
		return usuarioRepository.findByEmail(correo);
	}




	
	

	

}
