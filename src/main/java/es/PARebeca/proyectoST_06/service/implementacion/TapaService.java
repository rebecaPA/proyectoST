package es.PARebeca.proyectoST_06.service.implementacion;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.PARebeca.proyectoST_06.entity.Tapa;
import es.PARebeca.proyectoST_06.model.TapaModel;
import es.PARebeca.proyectoST_06.repository.TapaRepositorio;
import es.PARebeca.proyectoST_06.service.interfaces.Services;

@Service("tapaService")
public class TapaService implements Services<Tapa, TapaModel> {

	private static final Logger LOG = LoggerFactory.getLogger(TapaService.class);
	
	@Autowired
	@Qualifier("tapaRepositorio")
	TapaRepositorio repositorio;

	@Override
	public void save(Tapa c) {
		repositorio.save(c);	
	}

	@Override
	public List<Tapa> finder() {
		
		return (List<Tapa>) repositorio.findAll();
	}

	@Override
	public List<Tapa> finder(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tapa finderOne(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tapa value) {
		repositorio.delete(value);
		
	}

	@Override
	public boolean exist(Tapa value) {
		
		return false;
	}

	@Override
	public boolean exist(String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TapaModel> finderModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TapaModel> finderModel(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TapaModel finderOneMoidel(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tapa> findByFilters(String[] filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TapaModel> findByFiltersModel(String[] filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveModel(TapaModel model) {
		
		
	}

	@Override
	public List<TapaModel> findByFiltersModel(String[] filters, String order, Boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tapa> findByFilters(String[] filters, String order, Boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
