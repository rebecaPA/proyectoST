package es.PARebeca.proyectoST_06.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;

import es.PARebeca.proyectoST_06.entity.Tapa;

public class PrecioModel {


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long idPrecio;
   
    @OneToMany(cascade = CascadeType.MERGE, mappedBy="precios")
    private List<Tapa> tapas;
    
    @Max(4)
    private int precio, pvp;
    
    // --- constructores ---  \\
    
    public PrecioModel() {
		
	}
    
    public PrecioModel( List<Tapa> tapas, @Max(4) int precio, @Max(4) int pvp) {
		
		this.tapas = tapas;
		this.precio = precio;
		this.pvp = pvp;
	}
    

    // ---  get & set ---  \\



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
    
    
    // -- -- \\
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPrecio == null) ? 0 : idPrecio.hashCode());
		result = prime * result + precio;
		result = prime * result + pvp;
		result = prime * result + ((tapas == null) ? 0 : tapas.hashCode());
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
		PrecioModel other = (PrecioModel) obj;
		if (idPrecio == null) {
			if (other.idPrecio != null)
				return false;
		} else if (!idPrecio.equals(other.idPrecio))
			return false;
		if (precio != other.precio)
			return false;
		if (pvp != other.pvp)
			return false;
		if (tapas == null) {
			if (other.tapas != null)
				return false;
		} else if (!tapas.equals(other.tapas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Precio [idPrecio=" + idPrecio + ", tapas=" + tapas + ", precio=" + precio + ", pvp=" + pvp + "]";
	}

    

}
