package es.PARebeca.proyectoST_06.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import es.PARebeca.proyectoST_06.entity.Ingrediente;
import es.PARebeca.proyectoST_06.model.IngredienteModel;
import es.PARebeca.proyectoST_06.service.interfaces.Services;

/*
 * 
 * Autora:									Fecha:
 * 		rebeca pena alvarez			|   	 	03/03/2019
 * 										  
 * Comentario: 
 * 
 * 
 */
//@Controller("/crudIngredientes")
public class CRUDIngredientes {
	
	private static final Logger LOG = LoggerFactory.getLogger(CRUDIngredientes.class);
	
	@Autowired
	@Qualifier("")//dentro va el nombre de la clase servicio 
	private Services<Ingrediente , IngredienteModel> servicioIngrediente;
}
