/**
 * 
 */
package com.tienda.online.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.models.Compra;

/**
 * @author acardenas
 *
 */
@Repository
public interface CompraRepository extends CrudRepository<Compra, Integer> { // El tipo de dato depende de la clave primaria de la entidad

}
