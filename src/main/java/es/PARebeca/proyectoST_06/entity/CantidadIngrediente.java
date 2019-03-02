package es.PARebeca.proyectoST_06.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/*
 * 
 * Autora:									Fecha:
 * 		rebeca pena alvarez			|   	9/2/2019
 * 										  
 * Comentario: 
 * 
 *  encargada de hacer la lista de ingredientes de cada receta
 * 
 */
@Entity
public class CantidadIngrediente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idCantidadIngrediente;
	
	@Min(1)
	@Max(5)
	private int cantidad;
	
	
    //sistema internacional de unidades
    @Enumerated (EnumType.STRING)
    private SistemaInternacionalUnidades si;
	
	@ManyToMany
	@JoinTable(
   		 name = "CantidadIngredientesReceta",
            joinColumns = {
            	@JoinColumn (name = "idCantidadIngrediente",referencedColumnName = "idCantidadIngrediente")
            	
            },
            inverseJoinColumns = {
            	@JoinColumn (name = "idIngrediente",referencedColumnName = "idIngrediente")
            }
   		)
	private List<Ingrediente> ingredientes ;

	public CantidadIngrediente() {
	
	}

	public CantidadIngrediente(@Min(1) @Max(5) int cantidad, SistemaInternacionalUnidades si,
			List<Ingrediente> ingredientes) {
		super();
		this.cantidad = cantidad;
		this.si = si;
		this.ingredientes = ingredientes;
	}

	public int getIdCantidadIngrediente() {
		return idCantidadIngrediente;
	}

	public void setIdCantidadIngrediente(int idCantidadIngrediente) {
		this.idCantidadIngrediente = idCantidadIngrediente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public SistemaInternacionalUnidades getSi() {
		return si;
	}

	public void setSi(SistemaInternacionalUnidades si) {
		this.si = si;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + idCantidadIngrediente;
		result = prime * result + ((ingredientes == null) ? 0 : ingredientes.hashCode());
		result = prime * result + ((si == null) ? 0 : si.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CantidadIngrediente other = (CantidadIngrediente) obj;
		if (cantidad != other.cantidad)
			return false;
		if (idCantidadIngrediente != other.idCantidadIngrediente)
			return false;
		if (ingredientes == null) {
			if (other.ingredientes != null)
				return false;
		} else if (!ingredientes.equals(other.ingredientes))
			return false;
		if (si != other.si)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CantidadIngrediente [idCantidadIngrediente=" + idCantidadIngrediente + ", cantidad=" + cantidad
				+ ", si=" + si + ", ingredientes=" + ingredientes + "]";
	}
	
	
	
}
