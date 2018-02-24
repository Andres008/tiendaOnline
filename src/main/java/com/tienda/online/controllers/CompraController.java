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


import com.tienda.online.models.Compra;
import com.tienda.online.services.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	private static final Logger  logger = LoggerFactory.getLogger(Compra.class);
	
	private CompraService compraService;

	@Autowired
	public CompraController(CompraService compraService) {
		super();
		this.compraService = compraService;
	}
	
	@GetMapping(produces = "application/json")
	public List<Compra> obtener()
	{
		try {
			return compraService.obtenerTodoCompra();
		}catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtener Compra: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public Compra guardar(@RequestBody @Validated Compra compra)
	{
		try {
			return compraService.guardarCompra(compra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardar Compra: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@PutMapping(produces="application/json")
	public Compra actualizar(@RequestBody @Validated Compra compra)
	{
		try {
			return compraService.guardarCompra(compra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio actualizar Compra: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
	@RequestMapping(path="/{codigo}", produces="aplication/json", method= RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="codigo") Integer id) {
		try {
			compraService.eliminarCompra(id); 
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio eliminar Compra: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
}
