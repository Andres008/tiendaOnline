/**
 * 
 */
package com.tienda.online.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.models.Categoria;

/**
 * @author acardenas
 *
 */
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, String> {

}
