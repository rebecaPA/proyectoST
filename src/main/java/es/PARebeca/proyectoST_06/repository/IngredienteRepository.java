package es.PARebeca.proyectoST_06.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
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

	public abstract Ingrediente findIngredienteByIdIngrediente(Long idTapa);
	public abstract Ingrediente findIngredienteByNombre(String nombre);
	public abstract List<Ingrediente> findAll();
//	@Query("SELECT i FROM Ingrediente  i "
//			+ "WHERE NOT EXISTS("
//				+ "SELECT null FROM ingredientesReceta ir "
//					+ "WHERE i.idIngrediente = ir.idIngrediente )")
	@Query("SELECT i FROM Ingrediente i WHERE i.idIngrediente = 1")
	public abstract List<Ingrediente> listarAlmacenIngrediantes();
	
}
