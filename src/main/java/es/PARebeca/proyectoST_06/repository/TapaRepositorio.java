package es.PARebeca.proyectoST_06.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.PARebeca.proyectoST_06.entity.Tapa;

public interface TapaRepositorio extends CrudRepository<Tapa, Serializable>{

	public abstract Tapa findTapaByIdTapa(Long idTapa);
	public abstract Tapa findTapaByNombre(String nombre);
	public abstract List<Tapa> findAll();
	
	@Query("SELECT t FROM Tapa t WHERE t.servida = true")
	public abstract List<Tapa> buscarTapasServias();
	@Query("SELECT t FROM Tapa t WHERE t.servida = false")
	public abstract List<Tapa> buscarTapasNoservidas();
	
	// select * from proyectost.tapa as t where t.servida
}
