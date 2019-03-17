package es.PARebeca.proyectoST_06.service.interfaces;

import java.util.List;

import es.PARebeca.proyectoST_06.entity.Tapa;

public interface ServicioTapa {

	public abstract Tapa buscarId(Long id);
	public abstract List<Tapa> listarTapas();
	public abstract void crear(Long id);
	public abstract void borrar(Long id);
	public abstract List<Tapa> sorteo(int nDias, int nTapasCuchara, int nTapasPalillo);
	
}
