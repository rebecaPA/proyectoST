package es.PARebeca.proyectoST_06.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import es.PARebeca.proyectoST_06.entity.Precio;
import es.PARebeca.proyectoST_06.entity.Tapa;
import es.PARebeca.proyectoST_06.entity.Tipo;

public class TapaModel {
	 private static final long serialVersionUID = 1L;
	    
	    
	   
	    private Long idTapa;
	    
	    private Tipo tipo;
	  
	    private String nombre;

	    private Date fecha;
	    private boolean servida;
	    
	    private Precio precios;   
	    
	    
	    
	    
	    ////////
	    
	    
	    
	    public TapaModel() {
			
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
	    

		public Precio getPrecios() {
			return precios;
		}




		public void setPrecios(Precio precios) {
			this.precios = precios;
		}
		


		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
			result = prime * result + ((idTapa == null) ? 0 : idTapa.hashCode());
			result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
			result = prime * result + ((precios == null) ? 0 : precios.hashCode());
			result = prime * result + (servida ? 1231 : 1237);
			result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
			TapaModel other = (TapaModel) obj;
			if (fecha == null) {
				if (other.fecha != null)
					return false;
			} else if (!fecha.equals(other.fecha))
				return false;
			if (idTapa == null) {
				if (other.idTapa != null)
					return false;
			} else if (!idTapa.equals(other.idTapa))
				return false;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			if (precios == null) {
				if (other.precios != null)
					return false;
			} else if (!precios.equals(other.precios))
				return false;
			if (servida != other.servida)
				return false;
			if (tipo != other.tipo)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Tapa [idTapa=" + idTapa + ", tipo=" + tipo + ", nombre=" + nombre + ", fecha=" + fecha + ", servida="
					+ servida + /* ", recetas=" + recetas +  */ ", precios=" + precios + "]";
		}
	    

}
