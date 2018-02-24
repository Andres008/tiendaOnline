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

import com.tienda.online.models.Articulo;
import com.tienda.online.services.ArticuloService;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {

	private static final Logger  logger = LoggerFactory.getLogger(ArticuloController.class);
	private ArticuloService articuloService;
	
	@Autowired
	public ArticuloController(ArticuloService articuloService) {
		super();
		this.articuloService = articuloService;
	}
	
	@GetMapping(produces = "application/json")
	public List<Articulo> obtener()
	{
		try {
			return articuloService.obtenerTodosArticulos();
		}catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtener Articulo: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public Articulo guardar(@RequestBody @Validated Articulo articulo)
	{
		try {
			return articuloService.guardarArticulo(articulo);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardar Articulo: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@PutMapping(produces="application/json")
	public Articulo actualizar(@RequestBody @Validated Articulo articulo)
	{
		try {
			return articuloService.guardarArticulo(articulo);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio actualizar Articulo: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
	@RequestMapping(path="/{codigo}", produces="aplication/json", method= RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="codigo") Integer id) {
		try {
			articuloService.eliminar(id); 
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio eliminar Articulo: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
	
}
