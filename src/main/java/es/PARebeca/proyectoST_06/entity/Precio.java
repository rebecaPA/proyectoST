/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.PARebeca.proyectoST_06.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;

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
public class Precio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPrecio")
    @Basic(optional = false)
    private Long idPrecio;
   
    @OneToMany(cascade = CascadeType.MERGE, mappedBy="precios")
    private List<Tapa> tapas;
    
    @Max(4)
    private int precio, pvp;
    
    /////
    
    public Precio() {
    }
    
    public Precio(Long id, List<Tapa> tapas, @Max(4) int precio, @Max(4) int pvp) {
		super();
		this.idPrecio = id;
		this.tapas = tapas;
		this.precio = precio;
		this.pvp = pvp;
	}

//////


    
	public int getPrecio() {
        return precio;
    }

    public List<Tapa> getTapas() {
		return tapas;
	}

	public void setTapas(List<Tapa> tapas) {
		this.tapas = tapas;
	}

	public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPvp() {
        return pvp;
    }

    public void setPvp(int pvp) {
        this.pvp = pvp;
    }

    
    public Long getId() {
        return idPrecio;
    }

    public void setId(Long id ) {
        this.idPrecio = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecio != null ? idPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Precio)) {
            return false;
        }
        Precio other = (Precio) object;
        if ((this.idPrecio == null && other.idPrecio != null) || (this.idPrecio != null && !this.idPrecio.equals(other.idPrecio))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Precio [idPrecio=" + idPrecio + ", tapas=" + tapas + ", precio=" + precio + ", pvp=" + pvp + "]";
	}

    
    
//    @Override
//    public String toString() {
//        return "rebecaPA.proyectoST_06.entity.Precio[ id=" + idPrecio + " ]";
//    }
//    
}
