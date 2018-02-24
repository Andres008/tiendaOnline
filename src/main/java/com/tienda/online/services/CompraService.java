package com.tienda.online.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.models.Compra;
import com.tienda.online.repositories.CompraRepository;

@Service
public class CompraService {
	
	private CompraRepository compraRepository;

	@Autowired
	public CompraService(CompraRepository compraRepository) {
		super();
		this.compraRepository = compraRepository;
	}
	
	public Compra guardarCompra(Compra compra) {
		compra.setFecha(new Date());
		compra.setNroDocumento("00000000"+compraRepository.count()+1);
		compra.getListaDetalleCompra().forEach(detalle->{
			detalle.setCompraId(compra);
		});
		return compraRepository.save(compra);
	}
	
	public List<Compra> obtenerTodoCompra(){
		return (List<Compra>) compraRepository.findAll();
	}
	
	public void eliminarCompra(Integer id) {
		compraRepository.delete(id);
	}
	
	

}
