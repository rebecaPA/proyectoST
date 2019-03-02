/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.PARebeca.proyectoST_06.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/*
 * 
 * Autora:									Fecha:
 * 		rebeca pena alvarez			|   	02/08/2019
 * 										  
 * Comentario: 
 * 
 *  
 * 
 */
@Entity
public class Tapa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idTapa")
    private Long idTapa;
    
    //antes Condicion 
    @Enumerated
    private Tipo tipo;
    
    @NotBlank
    @Size(max=50)
    private String nombre;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private boolean servida;
    
//    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY, mappedBy= "tapa")
//    private List<Receta> recetas;
//    
    
   
    
    //entidad propietaria de la relacion 
//    @ManyToMany(cascade = {CascadeType.MERGE})
//    @JoinTable(
//    		//monbre de la tabla de union 
//            name = "tapaIngrediente",
//            joinColumns = { //nombre columna de tabal union, nombre c tabla Tapa
//                @JoinColumn(name = "idTapa", referencedColumnName = "idTapa")
//            },
//            inverseJoinColumns = {
//                @JoinColumn (name = "idIngrediente",referencedColumnName = "idIngrediente")
//            }
//    )
//    private List<Ingrediente> ingredientes;
//    
    @ManyToOne
    //name es el nombre de la clave foranea
    @JoinColumn(name="idprecio")
    private Precio precios;   
    
    
    
    
    ////////
    
    
    public Tapa() {
    }

   

 
   public Tapa(Tipo tipo, @NotBlank @Size(max = 50) String nombre, Date fecha, boolean servida,/* List<Receta> recetas,*/
			Precio precios) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.fecha = new Date();
		this.servida = false;
//		this.recetas = recetas;
		this.precios = precios;
	}

//////
    

    public Long getIdTapa() {
		return idTapa;
	}

	public void setIdTapa(Long idTapa) {
		this.idTapa = idTapa;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public String getNombre() {
        return nombre;
    }
	
	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isServida() {
        return servida;
    }

    public void setServida(boolean servida) {
        this.servida = servida;
    }
    

//    public List<Receta> getRecetas() {
//		return recetas;
//	}
//
//
//
//
//	public void setRecetas(List<Receta> recetas) {
//		this.recetas = recetas;
//	}




	public Precio getPrecios() {
		return precios;
	}




	public void setPrecios(Precio precios) {
		this.precios = precios;
	}
	

//    public List<Ingrediente> getIngredientes() {
//        return ingredientes;
//    }
//
//
//    public void setIngredientes(List<Ingrediente> ingredientes) {
//        this.ingredientes = ingredientes;
//    }

   





	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTapa != null ? idTapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tapa)) {
            return false;
        }
        Tapa other = (Tapa) object;
        if ((this.idTapa == null && other.idTapa != null) || (this.idTapa != null && !this.idTapa.equals(other.idTapa))) {
            return false;
        }
        return true;
    }




	@Override
	public String toString() {
		return "Tapa [idTapa=" + idTapa + ", tipo=" + tipo + ", nombre=" + nombre + ", fecha=" + fecha + ", servida="
				+ servida + /* ", recetas=" + recetas +  */ ", precios=" + precios + "]";
	}
    

//    @Override
//    public String toString() {
//        return "rebecaPA.proyectoST_06.entity.Tapa[ id=" + idTapa + " ]";
//    }
//    
}
