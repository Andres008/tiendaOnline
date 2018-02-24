package com.tienda.online.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.models.DetalleCompra;

@Repository
public interface DetalleCompraRepository extends CrudRepository<DetalleCompra, Integer> {

}
