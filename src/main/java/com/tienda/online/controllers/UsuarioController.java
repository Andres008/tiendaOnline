package com.tienda.online.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.mockito.internal.stubbing.answers.ThrowsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.models.Usuario;
import com.tienda.online.models.dto.response.ErrorResponse;
import com.tienda.online.services.UsuarioService;

@RequestMapping("/usuario")
@RestController
public class UsuarioController extends BaseController {
	private static final Logger  logger = LoggerFactory.getLogger(Usuario.class);
	
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@GetMapping(produces = "application/json")
	public List<Usuario> obtener()
	{
		try {
			return usuarioService.obtenerTodoUsuario();
		}catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtener Usuario: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public Usuario guardar(@RequestBody @Validated Usuario usuario)
	{
		try {
			Usuario usuarioNuevo = usuarioService.guardarUsuario(usuario);
			if(usuarioNuevo==null)
			{
				throw new DataIntegrityViolationException("Ya existe el usuario registrado con el email ingresado: ");
			}
			return usuarioNuevo;
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardar Usuario: "+e.getMessage());
			throw new DataIntegrityViolationException("Error en el consumo del servicio guardar Usuario: "+e.getMessage());
		}
	}
	
	@PutMapping(produces="application/json")
	public Usuario actualizar(@RequestBody @Validated Usuario usuario)
	{
		try {
			return usuarioService.guardarUsuario(usuario);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio actualizar Usuario: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
	@RequestMapping(path="/{codigo}", produces="aplication/json", method= RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="codigo") Integer id) {
		try {
			usuarioService.eliminarUsuario(id);
			
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio eliminar Usuario: "+e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
}
