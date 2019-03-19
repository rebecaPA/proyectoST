package es.PARebeca.proyectoST_06.service.implementacion;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.PARebeca.proyectoST_06.entity.Ingrediente;
import es.PARebeca.proyectoST_06.repository.IngredienteRepository;
import es.PARebeca.proyectoST_06.service.interfaces.ServicioIngrediente;

@Service("servicioIngredienteImpl")
public class ServicioIngredienteImpl implements ServicioIngrediente {
	
	private static final Logger LOG = LoggerFactory.getLogger(ServicioIngredienteImpl.class);
	
	@Autowired
	@Qualifier("ingredienteRepository")
	private IngredienteRepository repositorioI;
	private Ingrediente i=null;
	
	@Override
	public Ingrediente buscarIngrediente(Long idTapa) {
		
		LOG.info("-- ServicioIngredienteImpl.buscarIngrediente()");
		
		try {
			i= repositorioI.findIngredienteByIdIngrediente(idTapa);
			
		} catch (Exception e) {
			
			i=null;
		}
		
		return i;
	}

	@Override
	public Ingrediente buscarNombreIngrediente(String nombre) {
		
		LOG.info("-- ServicioIngredienteImpl.buscarNombreIngrediente()");
		
		return repositorioI.findIngredienteByNombre(nombre);
	}

	@Override
	public List<Ingrediente> listarIngredientes() {
		
		LOG.info("-- ServicioIngredienteImpl.listarIngredientes()");
		
		return repositorioI.findAll();
	}

	@Override
	public List<Ingrediente> listarAlmacenIngredientes() {
		
		LOG.info("-- ServicioIngredienteImpl.listarAlmacenIngredientes()");
		
		return  repositorioI.listarAlmacenIngrediantes();
	}

	@Override
	public void crear_modificarIngrediente(Ingrediente i) {
		LOG.info("-- ServicioIngredienteImpl.crear_modificarIngrediente()");
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarIngrediente(Long idIngrediente) {
		LOG.info("-- ServicioIngredienteImpl.borrarIngrediente()");
		// TODO Auto-generated method stub

	}

}
