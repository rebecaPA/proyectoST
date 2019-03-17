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
import es.PARebeca.proyectoST_06.service.interfaces.ServicioTapa;

@Service("tapaService")
public class TapaService implements ServicioTapa {

	private static final Logger LOG = LoggerFactory.getLogger(TapaService.class);
	
	@Autowired
	@Qualifier("tapaRepositorio")
	TapaRepositorio repositorio;

	@Override
	public Tapa buscarId(Long id) {
		LOG.info("-- tapaServicio.buscarId()");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tapa> listarTapas() {
		LOG.info("-- tapaServicio.listar()");
	
		return repositorio.findAll();
		
	}

	@Override
	public void crear(Long id) {
		LOG.info("-- tapaServicio.crear()");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Long id) {
		LOG.info("-- tapaServicio.borrar()");
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tapa> sorteo(int nDias, int nTapasCuchara, int nTapasPalillo) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
