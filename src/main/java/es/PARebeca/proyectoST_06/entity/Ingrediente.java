package es.PARebeca.proyectoST_06.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author rebeca pena alvarez
 * 18/01/2019
 *  elemento minimo  para realizar la tapa,   que tiene en el almacen
 */
@Entity
public class Ingrediente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idIngrediente")
    private Long idIngrediente;

    
    //modo de agrupar los ingredientes 
    @Enumerated (EnumType.STRING)
    private Grupo grupo;
   
  //  private boolean receta;
    
    @NotBlank
    @Size(max=50)
    private String nombre;
     
    //la canidad en el almacen, futuros spring  disminución automatica segun uso (puede q se pase a una tabla con si)
 
    @ManyToMany(mappedBy = "ingredientes")
    private List<CantidadIngrediente> cantidadIngredientes;
   
    @ManyToMany
    @JoinTable(
    		 name = "ingredientesReceta",
             joinColumns = {
            	@JoinColumn (name = "idIngrediente",referencedColumnName = "idIngrediente")
             },
             inverseJoinColumns = {
            	@JoinColumn(name = "idReceta", referencedColumnName = "idReceta")	
             }
    		)
    private List<Receta> recetas;
    
    
  // constructores

    public Ingrediente() {
    }

    public Ingrediente( Grupo grupo, @NotBlank @Size(max = 50) String nombre,
			List<CantidadIngrediente> cantidadIngredientes /*, List<Receta>recetas*/) {
		this.grupo = grupo;
		this.nombre = nombre;
		this.cantidadIngredientes = cantidadIngredientes;
//		this.recetas= recetas;
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
	

	
	/////
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidadIngredientes == null) ? 0 : cantidadIngredientes.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((idIngrediente == null) ? 0 : idIngrediente.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((recetas == null) ? 0 : recetas.hashCode());
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
		Ingrediente other = (Ingrediente) obj;
		if (cantidadIngredientes == null) {
			if (other.cantidadIngredientes != null)
				return false;
		} else if (!cantidadIngredientes.equals(other.cantidadIngredientes))
			return false;
		if (grupo != other.grupo)
			return false;
		if (idIngrediente == null) {
			if (other.idIngrediente != null)
				return false;
		} else if (!idIngrediente.equals(other.idIngrediente))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (recetas == null) {
			if (other.recetas != null)
				return false;
		} else if (!recetas.equals(other.recetas))
			return false;
		return true;
	}

	


	

	@Override
	public String toString() {
		return "Ingrediente [idIngrediente=" + idIngrediente + ", grupo=" + grupo + ", nombre=" + nombre
				+ ", cantidadIngredientes=" + cantidadIngredientes + ", recetas=" + recetas +"]";
	}

	
	
    ////mirar
   /* @Override
    public String toString() {
        return "es.PARebeca.proyectoST_06.entity[ idIngrediente=" + idIngrediente + " ]";
    }
    */
	
}
