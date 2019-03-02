package es.PARebeca.proyectoST_06.service.interfaces;

import java.util.List;

/*
 * 
 * Autora:									Fecha:
 * 		rebeca pena alvarez			|   	 	02/03/2019
 * 										  
 * Comentario: 
 * 		Interfaz para el acceso a los servicios a traves de ella
 * 
 */
public interface Services<C, M> {

	
	
	public abstract void save(C c);
	public abstract List<C> finder();
	public abstract List<C> finder(String field, String value);
	public abstract C finderOne(String field, String value);
	public abstract void delete(String value);
	public abstract void delete(C value);
	public abstract boolean exist(C value);
	public abstract boolean exist(String value);

	public abstract List<M> finderModel();
	public abstract List<M> finderModel(String field, String value);
	public abstract M finderOneMoidel(String field, String value);

	
	public abstract List<C> findByFilters(String[] filters);
	public abstract List<M> findByFiltersModel(String[] filters);
	public abstract void saveModel(M model);
	List<M> findByFiltersModel(String[] filters, String order, Boolean asc);
	List<C> findByFilters(String[] filters, String order, Boolean asc); 
}
