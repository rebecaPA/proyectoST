package es.PARebeca.proyectoST_06.entity;

import java.awt.Image;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class DatosEmpresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDatosEmpresa;
	
	@NotNull
	@NotBlank
	private String Nombre;
	
	@Min(value = 1)
	@Max(value = 100)
	private int numeroTapasSorteoPalillo;
	
	@Min(value = 1)
	@Max(value = 100)
	private int numeroTapasSorteoCuchara;
	
	//con ( numeroTapasSorteoPalillo + numeroTapasSorteoCuchara) X numeroDiasASortear da el nº total de tapas 
	@Min(value = 1)
	@Max(value = 31)
	private int numeroDiasASortear;
	
	private Image logo;

	
	
	///////////////
	
	public DatosEmpresa() {
		
	}


	public DatosEmpresa(@NotNull @NotBlank String nombre, @Min(1) @Max(100) int numeroTapasSorteoPalillo,
			@Min(1) @Max(100) int numeroTapasSorteoCuchara, @Min(1) @Max(31) int numeroDiasASortear, Image logo) {
		super();
		Nombre = nombre;
		this.numeroTapasSorteoPalillo = numeroTapasSorteoPalillo;
		this.numeroTapasSorteoCuchara = numeroTapasSorteoCuchara;
		this.numeroDiasASortear = numeroDiasASortear;
		this.logo = logo;
	}


	
	///////////////////
	
	public int getIdDatosEmpresa() {
		return idDatosEmpresa;
	}


	public void setIdDatosEmpresa(int idDatosEmpresa) {
		this.idDatosEmpresa = idDatosEmpresa;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public int getNumeroTapasSorteoPalillo() {
		return numeroTapasSorteoPalillo;
	}


	public void setNumeroTapasSorteoPalillo(int numeroTapasSorteoPalillo) {
		this.numeroTapasSorteoPalillo = numeroTapasSorteoPalillo;
	}


	public int getNumeroTapasSorteoCuchara() {
		return numeroTapasSorteoCuchara;
	}


	public void setNumeroTapasSorteoCuchara(int numeroTapasSorteoCuchara) {
		this.numeroTapasSorteoCuchara = numeroTapasSorteoCuchara;
	}


	public int getNumeroDiasASortear() {
		return numeroDiasASortear;
	}


	public void setNumeroDiasASortear(int numeroDiasASortear) {
		this.numeroDiasASortear = numeroDiasASortear;
	}


	public Image getLogo() {
		return logo;
	}


	public void setLogo(Image logo) {
		this.logo = logo;
	}


	///////////////////
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + idDatosEmpresa;
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + numeroDiasASortear;
		result = prime * result + numeroTapasSorteoCuchara;
		result = prime * result + numeroTapasSorteoPalillo;
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
		DatosEmpresa other = (DatosEmpresa) obj;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (idDatosEmpresa != other.idDatosEmpresa)
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (numeroDiasASortear != other.numeroDiasASortear)
			return false;
		if (numeroTapasSorteoCuchara != other.numeroTapasSorteoCuchara)
			return false;
		if (numeroTapasSorteoPalillo != other.numeroTapasSorteoPalillo)
			return false;
		return true;
	}


	///////////////////
	
	@Override
	public String toString() {
		return "DatosEmpresa [idDatosEmpresa=" + idDatosEmpresa + ", Nombre=" + Nombre + ", numeroTapasSorteoPalillo="
				+ numeroTapasSorteoPalillo + ", numeroTapasSorteoCuchara=" + numeroTapasSorteoCuchara
				+ ", numeroDiasASortear=" + numeroDiasASortear + ", logo=" + logo + "]";
	}
	
		
	

}
