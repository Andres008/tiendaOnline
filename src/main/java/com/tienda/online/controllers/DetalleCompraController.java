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


import com.tienda.online.models.DetalleCompra;
import com.tienda.online.services.DetalleCompraService;

@RestController
@RequestMapping("/detalleCompra")
public class DetalleCompraController {
	
	private static final Logger  logger = LoggerFactory.getLogger(DetalleCompra.class);
	
	private DetalleCompraService detalleCompraService;

	@Autowired
	public DetalleCompraController(DetalleCompraService detalleCompraService) {
		super();
		this.detalleCompraService = detalleCompraService;
	}

	@GetMapping(produces = "application/json")
	public List<DetalleCompra> obtener()
	{
		try {
			return detalleCompraService.obtenerTodoDetalleCompra();
		}catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtener DetalleCompra: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public DetalleCompra guardar(@RequestBody @Validated DetalleCompra detalleCompra)
	{
		try {
			return detalleCompraService.guardarDetalleCompra(detalleCompra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardar DetalleCompra: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@PutMapping(produces="application/json")
	public DetalleCompra actualizar(@RequestBody @Validated DetalleCompra detalleCompra)
	{
		try {
			return detalleCompraService.guardarDetalleCompra(detalleCompra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio actualizar DetalleCompra: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
	@RequestMapping(path="/{codigo}", produces="aplication/json", method= RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="codigo") Integer id) {
		try {
			detalleCompraService.eliminarDetalleCompra(id); 
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio eliminar DetalleCompra: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	

}
