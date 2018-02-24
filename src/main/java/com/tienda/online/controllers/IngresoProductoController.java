package com.tienda.online.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.tienda.online.models.IngresoProducto;
import com.tienda.online.services.IngresoProductoService;

@RestController
@RequestMapping("/ingresoProducto")
public class IngresoProductoController {

	private static final Logger  logger = LoggerFactory.getLogger(IngresoProducto.class);
	
	private IngresoProductoService ingresoProductoService;

	public IngresoProductoController(IngresoProductoService ingresoProductoService) {
		super();
		this.ingresoProductoService = ingresoProductoService;
	}
	
	@GetMapping(produces = "application/json")
	public List<IngresoProducto> obtener()
	{
		try {
			return ingresoProductoService.buscarTodoIgresoProducto();
		}catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtener IngresoProducto: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public IngresoProducto guardar(@RequestBody @Validated IngresoProducto ingresoProducto)
	{
		try {
			return ingresoProductoService.guardarIngresoProducto(ingresoProducto);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardar IngresoProducto: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@PutMapping(produces="application/json")
	public IngresoProducto actualizar(@RequestBody @Validated IngresoProducto ingresoProducto)
	{
		try {
			return ingresoProductoService.guardarIngresoProducto(ingresoProducto);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio actualizar IngresoProducto: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
	@RequestMapping(path="/{codigo}", produces="aplication/json", method= RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="codigo") Integer id) {
		try {
			ingresoProductoService.eliminarIngresoProducto(id);
			
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio eliminar IngresoProducto: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
}
