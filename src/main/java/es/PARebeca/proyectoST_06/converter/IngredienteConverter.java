package es.PARebeca.proyectoST_06.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.tomcat.util.net.openssl.ciphers.Cipher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.PARebeca.proyectoST_06.entity.CantidadIngrediente;
import es.PARebeca.proyectoST_06.entity.Ingrediente;
import es.PARebeca.proyectoST_06.model.CantidadIngredienteModel;
import es.PARebeca.proyectoST_06.model.CantidadModel;
import es.PARebeca.proyectoST_06.model.IngredienteModel;

@Component("ingredienteConverter")
public class IngredienteConverter implements Converter<Ingrediente, IngredienteModel> {

	@Override
	public IngredienteModel entityToModel(Ingrediente entity) {

		IngredienteModel model= new IngredienteModel();
		
		model.setIdIngrediente(entity.getIdIngrediente());
		model.setGrupo(entity.getGrupo());
		model.setNombre(entity.getNombre());
		model.setRecetas(entity.getRecetas());
		
		List<CantidadIngredienteModel> cantidadIngredientes = new ArrayList<CantidadIngredienteModel>();
		CantidadIngredienteModel cimodel = new CantidadIngredienteModel();
		
		if(entity.getCantidadIngredientes().get(0).getIdCantidadIngrediente()!=0) {
			for(CantidadIngrediente ci : entity.getCantidadIngredientes()) {
				
				cimodel.setCantidad(ci.getCantidad());
				cimodel.setIdCantidadIngrediente(ci.getCantidad());
				cimodel.setSi(ci.getSi());
				
				
				cantidadIngredientes.addAll((Collection<? extends CantidadIngredienteModel>) cimodel);
			}
			model.setCantidadIngredientes(cantidadIngredientes);
		}
		else {
			model.setCantidadIngredientes(null);
		}
		
		
		
		
		return model;
	}
	
	@Autowired
	@Qualifier("ingredienteService")
	@Override
	public Ingrediente modelToEntity(IngredienteModel model) {
		// TODO Auto-generated method stub
		return entity;
	}

}
