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

import com.tienda.online.models.Categoria;
import com.tienda.online.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	private static final Logger  logger = LoggerFactory.getLogger(Categoria.class);
	
	private CategoriaService categoriaService;

	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}
	
	@GetMapping(produces = "application/json")
	public List<Categoria> obtener()
	{
		try {
			return categoriaService.obtenerTodosCategoria();
		}catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtener Categoria: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public Categoria guardar(@RequestBody @Validated Categoria categoria)
	{
		try {
			return categoriaService.guardarCategoria(categoria);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardar Categoria: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@PutMapping(produces="application/json")
	public Categoria actualizar(@RequestBody @Validated Categoria categoria)
	{
		try {
			return categoriaService.guardarCategoria(categoria);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio actualizar Categoria: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
	@RequestMapping(path="/{codigo}", produces="aplication/json", method= RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="codigo") String id) {
		try {
			categoriaService.eliminarCategoria(id); 
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio eliminar Categoria: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	

}
