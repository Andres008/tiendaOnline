package com.tienda.online.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.models.Rol;
import com.tienda.online.services.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {
	
	private static final Logger  logger = LoggerFactory.getLogger(RolController.class);
	private RolService rolService;
	
	@Autowired
	public RolController(RolService rolService) {
		super();
		this.rolService = rolService;
	}
	
	@GetMapping(produces = "application/json")
	public List<Rol> obtener()
	{
		try {
			return rolService.obtenerTodoRol();
		}catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtener Roles: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public Rol guardar(@RequestBody @Validated Rol rol)
	{
		try {
			return rolService.guardarRol(rol);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardar Roles: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@PutMapping(produces="application/json")
	public Rol actualizar(@RequestBody @Validated Rol rol)
	{
		try {
			return rolService.guardarRol(rol);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio actualizar Roles: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
	@RequestMapping(path="/{codigo}", produces="aplication/json", method= RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="codigo") Integer id) {
		try {
			rolService.eliminarRol(id); 
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio eliminar Rol: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

}
