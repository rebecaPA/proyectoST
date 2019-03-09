package es.PARebeca.proyectoST_06.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import es.PARebeca.proyectoST_06.entity.Ingrediente;

/*
 * 
 * Autora:									Fecha:
 * 		rebeca pena alvarez			|   	 	01/03/2019
 * 										  
 * Comentario: 
 * 		repositrorio para el aceso a la base de datos de la tabla ingredientes
 * 
 */
public interface IngredienteRepository extends CrudRepository<Ingrediente, Serializable> {

	//public abstract Ingrediente findIngredienteByIngrediente(Long idIngrediente);
}
