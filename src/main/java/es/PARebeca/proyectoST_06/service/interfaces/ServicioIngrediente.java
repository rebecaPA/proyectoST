package es.PARebeca.proyectoST_06.service.interfaces;

import java.util.List;

import es.PARebeca.proyectoST_06.entity.Ingrediente;

public interface ServicioIngrediente {
	public abstract Ingrediente buscarIngrediente(Long idTapa);
	public abstract Ingrediente buscarNombreIngrediente(String nombre);
	public abstract List<Ingrediente> listarIngredientes();
	public abstract List<Ingrediente> listarAlmacenIngredientes();
	public abstract void crear_modificarIngrediente(Ingrediente i);
	public abstract void borrarIngrediente(Long idIngrediente);

}
