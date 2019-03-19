package es.PARebeca.proyectoST_06.controler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.PARebeca.proyectoST_06.constantes.Constantes;
import es.PARebeca.proyectoST_06.entity.CantidadIngrediente;
import es.PARebeca.proyectoST_06.entity.Ingrediente;
import es.PARebeca.proyectoST_06.service.interfaces.ServicioIngrediente;

/*
 * 
 * Autora:									Fecha:
 * 		rebeca pena alvarez			|   	 	03/03/2019
 * 										  
 * Comentario: 
 * 
 * 
 */
@SessionAttributes("datosEmpresaModel")
@Controller("proyectoST/Ingredientes/*")
public class CRUDIngredientesControler {
	
	private static final Logger LOG = LoggerFactory.getLogger(CRUDIngredientesControler.class);
	
	@Autowired
	@Qualifier("servicioIngredienteImpl")
	private ServicioIngrediente servicioI;
	
	
	@GetMapping("proyectoST/Ingredientes/crear")
	private String crearIngredientes(Model model) {
		LOG.info("-- entrade en CRUDIngredientesControler.listarIngredientes()");
		
		model.addAttribute("datosEmpresaModel", "El Canalla");
		model.addAttribute("ingredientesModel", new Ingrediente());
		model.addAttribute("cantidadIngrediente", new CantidadIngrediente());
		
		return Constantes.INGREDIENTE;	
	}
	
	@GetMapping("proyectoST/Ingredientes/creado")
	private String creadoIngredientes(Model model) {
		LOG.info("-- entrade en CRUDIngredientesControler.listarIngredientes()");
		return Constantes.INGREDIENTES_LISTA;
	}
	
	@GetMapping("proyectoST/Ingredientes/listar")
	private String listarIngredientes(Model model) {
		LOG.info("-- entrade en CRUDIngredientesControler.listarIngredientes()");
		
		model.addAttribute("datosEmpresaModel", "El Canalla");
		model.addAttribute("ingredientesModel", servicioI.listarIngredientes());
		return Constantes.INGREDIENTES_LISTA;	
	}
	
}
