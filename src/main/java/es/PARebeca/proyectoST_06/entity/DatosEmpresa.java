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
	

}
