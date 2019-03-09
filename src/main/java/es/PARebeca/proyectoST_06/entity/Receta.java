package es.PARebeca.proyectoST_06.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/*
 * 
 * Autora:									Fecha:
 * 		rebeca pena alvarez			|   	 	18/02/2019
 * 										  
 * Comentario: 
 * 
 * 
 */
@Entity
public class Receta implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idReceta;
	
	@NotNull
	@NotBlank
	@Size(max=50)
	private String nombre;
	
	@NotNull
	@NotBlank
	@Size(max=1500)
	private String descripcion;
	
	@ManyToMany( mappedBy = "recetas")
	private List <Ingrediente> ingredietes;
	
	@ManyToOne
	@JoinColumn(name="idTapa")
	private Tapa tapa;
		
	@ManyToOne
	@JoinColumn(name="datosEmpresa")
	private DatosEmpresa datosEmpresa;  
	
	
	
	public Receta() {
	}

	public Receta(@NotNull @NotBlank @Size(max = 50) String nombre,
			@NotNull @NotBlank @Size(max = 1500) String descripcion, List<Ingrediente> ingredietes,
			es.PARebeca.proyectoST_06.entity.Tapa tapa, DatosEmpresa datosEmpresa) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ingredietes = ingredietes;
		this.tapa = tapa;
		this.datosEmpresa = datosEmpresa;
	}



	/////////
	
	
	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public List<Ingrediente> getIngredietes() {
		return ingredietes;
	}

	public void setIngredietes(List<Ingrediente> ingredietes) {
		this.ingredietes = ingredietes;
	}

	public Tapa getTapa() {
		return tapa;
	}

	public void Tapa(Tapa tapa) {
		this.tapa = tapa;
	}
	
	// ---  ---  \\

	@Override
	public String toString() {
		return "Receta [idReceta=" + idReceta + ", nombre=" + nombre + ", descripcion=" + descripcion + ", ingredietes="
				+ ingredietes + ", tapa=" + tapa + ", datosEmpresa=" + datosEmpresa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datosEmpresa == null) ? 0 : datosEmpresa.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + idReceta;
		result = prime * result + ((ingredietes == null) ? 0 : ingredietes.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tapa == null) ? 0 : tapa.hashCode());
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
		Receta other = (Receta) obj;
		if (datosEmpresa == null) {
			if (other.datosEmpresa != null)
				return false;
		} else if (!datosEmpresa.equals(other.datosEmpresa))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idReceta != other.idReceta)
			return false;
		if (ingredietes == null) {
			if (other.ingredietes != null)
				return false;
		} else if (!ingredietes.equals(other.ingredietes))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tapa == null) {
			if (other.tapa != null)
				return false;
		} else if (!tapa.equals(other.tapa))
			return false;
		return true;
	}
	
		
	
	
}
