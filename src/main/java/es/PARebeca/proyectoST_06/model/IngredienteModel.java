package es.PARebeca.proyectoST_06.model;

import java.util.List;

import es.PARebeca.proyectoST_06.entity.CantidadIngrediente;
import es.PARebeca.proyectoST_06.entity.Grupo;
import es.PARebeca.proyectoST_06.entity.Receta;

public class IngredienteModel {
	
	
	    private Long idIngrediente;

	    
	    private Grupo grupo;
	   
	  
	    private String nombre;
	     
	    
	    private List<CantidadIngrediente> cantidadIngredientes;
	   
	   
	    private List<Receta> recetas;
	    
	    
	  // constructores

	    public  IngredienteModel() {
	
	    }

	    
	// get set

		public Long getIdIngrediente() {
			return idIngrediente;
		}


		public void setIdIngrediente(Long idIngrediente) {
			this.idIngrediente = idIngrediente;
		}


		public Grupo getGrupo() {
			return grupo;
		}


		public void setGrupo(Grupo grupo) {
			this.grupo = grupo;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public List<CantidadIngrediente> getCantidadIngredientes() {
			return cantidadIngredientes;
		}

		public void setCantidadIngredientes(List<CantidadIngrediente> cantidadIngredientes) {
			this.cantidadIngredientes = cantidadIngredientes;
		}

		public List<Receta> getRecetas() {
			return recetas;
		}

		public void setRecetas(List<Receta> recetas) {
			this.recetas = recetas;
		}
		

}
