package com.tienda.online;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tienda.online.models.Categoria;
import com.tienda.online.models.Rol;
import com.tienda.online.services.CategoriaService;
import com.tienda.online.services.RolService;


@SpringBootApplication
public class TiendaOnlineApplication implements CommandLineRunner {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private RolService rolService;
	
	public static void main(String[] args) {
		SpringApplication.run(TiendaOnlineApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		//categoriaService.guardarCategoria(new Categoria("2", "Ejemplo 2"));
		//categoriaService.eliminarCategoria("2");
		rolService.guardarRol(new Rol(1,"Rol", "Descripcion"));
		
	}
	
}
