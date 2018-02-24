package com.tienda.online.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.online.models.Usuario;
import com.tienda.online.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario guardarUsuario(Usuario usuario) {
		usuario.setFecha(new Date());
		Usuario usuarioExiste = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(usuarioExiste == null)
			return usuarioRepository.save(usuario);
		return null;
	}
	
	public List<Usuario> obtenerTodoUsuario(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public void eliminarUsuario(Integer id) {
		usuarioRepository.delete(id);
	}
}
