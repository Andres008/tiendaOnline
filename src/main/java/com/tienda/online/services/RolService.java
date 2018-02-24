package com.tienda.online.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.online.models.Rol;
import com.tienda.online.repositories.RolRepository;

@Service
public class RolService {

	private RolRepository rolRepository;

	public RolService(RolRepository rolRepository) {
		super();
		this.rolRepository = rolRepository;
	}
	
	public Rol guardarRol (Rol rol) {
		return rolRepository.save(rol);
	}
	
	public List<Rol> obtenerTodoRol(){
		return (List<Rol>) rolRepository.findAll();
	}
	
	public void  eliminarRol(Integer id) {
		rolRepository.delete(id);
	}
}
