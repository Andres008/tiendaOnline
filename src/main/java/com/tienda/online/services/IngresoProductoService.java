package com.tienda.online.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.models.IngresoProducto;
import com.tienda.online.repositories.IngresoProductoRepository;

@Service
public class IngresoProductoService {

	private IngresoProductoRepository ingresoProductoRepository;

	@Autowired
	public IngresoProductoService(IngresoProductoRepository ingresoProductoRepository) {
		super();
		this.ingresoProductoRepository = ingresoProductoRepository;
	}
	
	public IngresoProducto guardarIngresoProducto(IngresoProducto ingresoProducto) {
		return ingresoProductoRepository.save(ingresoProducto);
	}
	
	public List<IngresoProducto> buscarTodoIgresoProducto(){
		return (List<IngresoProducto>) ingresoProductoRepository.findAll();
	}
	
	public void eliminarIngresoProducto (Integer id) {
		ingresoProductoRepository.delete(id);
	}
	
}
