package es.PARebeca.proyectoST_06.entity;

import java.awt.Image;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * 
 * Autora:									Fecha:
 * 		rebeca pena alvarez			|   	28/2/2019
 * 										  
 * Comentario: 
 * 		entidad que gestiona los datos que son distintos en cada empresa  
 * 
 */
@Entity
public class DatosEmpresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDatosEmpresa;
	
	@NotNull
	@NotBlank
	@Size(min=1, max=80)
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
	
	@Lob
	@Basic(optional = false, fetch = FetchType.EAGER)
	@Column(name="logo", nullable=true)
	private byte[] logo;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy="datosEmpresa")
//	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER )
//	@JoinColumn(name="idDatosEmpresa")
	private List<Receta> recetas;
	
	
	// --- consturctores ---\\
	
	public DatosEmpresa() {
	
	}

	
	public DatosEmpresa(@NotNull @NotBlank String nombre, @Min(1) @Max(100) int numeroTapasSorteoPalillo,
			@Min(1) @Max(100) int numeroTapasSorteoCuchara, @Min(1) @Max(31) int numeroDiasASortear, byte[] logo,
			List<Receta> recetas) {
		super();
		Nombre = nombre;
		this.numeroTapasSorteoPalillo = numeroTapasSorteoPalillo;
		this.numeroTapasSorteoCuchara = numeroTapasSorteoCuchara;
		this.numeroDiasASortear = numeroDiasASortear;
		this.logo = logo;
		this.recetas = recetas;
	}

	// --- get & set ---\\
	
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

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "DatosEmpresa [idDatosEmpresa=" + idDatosEmpresa + ", Nombre=" + Nombre + ", numeroTapasSorteoPalillo="
				+ numeroTapasSorteoPalillo + ", numeroTapasSorteoCuchara=" + numeroTapasSorteoCuchara
				+ ", numeroDiasASortear=" + numeroDiasASortear + ", logo=" + logo + ", recetas=" + recetas + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + idDatosEmpresa;
		result = prime * result + Arrays.hashCode(logo);
		result = prime * result + numeroDiasASortear;
		result = prime * result + numeroTapasSorteoCuchara;
		result = prime * result + numeroTapasSorteoPalillo;
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
		DatosEmpresa other = (DatosEmpresa) obj;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (idDatosEmpresa != other.idDatosEmpresa)
			return false;
		if (!Arrays.equals(logo, other.logo))
			return false;
		if (numeroDiasASortear != other.numeroDiasASortear)
			return false;
		if (numeroTapasSorteoCuchara != other.numeroTapasSorteoCuchara)
			return false;
		if (numeroTapasSorteoPalillo != other.numeroTapasSorteoPalillo)
			return false;
		if (recetas == null) {
			if (other.recetas != null)
				return false;
		} else if (!recetas.equals(other.recetas))
			return false;
		return true;
	}

	
	
}