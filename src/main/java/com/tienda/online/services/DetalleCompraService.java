package com.tienda.online.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.models.DetalleCompra;
import com.tienda.online.repositories.DetalleCompraRepository;

@Service
public class DetalleCompraService {

	private DetalleCompraRepository detalleCompraRepository;

	@Autowired
	public DetalleCompraService(DetalleCompraRepository detalleCompraRepository) {
		super();
		this.detalleCompraRepository = detalleCompraRepository;
	}
	
	public DetalleCompra guardarDetalleCompra (DetalleCompra detalleCompra) {
		return detalleCompraRepository.save(detalleCompra);
	}
	
	public List<DetalleCompra> obtenerTodoDetalleCompra(){
		return (List<DetalleCompra>) detalleCompraRepository.findAll();
	}
	
	public void eliminarDetalleCompra (Integer id) {
		detalleCompraRepository.delete(id);
	}
	
}
