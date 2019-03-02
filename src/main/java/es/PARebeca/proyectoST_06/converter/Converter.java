package es.PARebeca.proyectoST_06.converter;

/*
 * 
 * Autora:									Fecha:
 * 		rebeca pena alvarez			|   	 	01/03/2019
 * 										  
 * Comentario: 
 * 
 * 
 */
public interface Converter<E,M> {
	
	public M entityToModel(E entity);
	public E modelToEntity(M model);
}
