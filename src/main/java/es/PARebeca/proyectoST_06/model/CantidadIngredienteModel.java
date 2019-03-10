package es.PARebeca.proyectoST_06.model;

import java.util.List;

import es.PARebeca.proyectoST_06.entity.Ingrediente;
import es.PARebeca.proyectoST_06.entity.SistemaInternacionalUnidades;

public class CantidadIngredienteModel {

	
private static final long serialVersionUID = 1L;
	
	
	private int idCantidadIngrediente;
	
	private int cantidad;
	
    private SistemaInternacionalUnidades si;
	
	
	
	
	

	public CantidadIngredienteModel() {
	
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

	
}

