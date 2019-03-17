package es.PARebeca.proyectoST_06.controler;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import es.PARebeca.proyectoST_06.constantes.Constantes;
import es.PARebeca.proyectoST_06.entity.Precio;
import es.PARebeca.proyectoST_06.entity.Tapa;
import es.PARebeca.proyectoST_06.model.PrecioModel;
import es.PARebeca.proyectoST_06.model.TapaModel;
import es.PARebeca.proyectoST_06.service.interfaces.Services;
import es.PARebeca.proyectoST_06.service.interfaces.ServicioTapa;


@Controller("proyectoST/tapa/*")
public class CRUDTapaControler {

	private static final Logger LOG = LoggerFactory.getLogger(CRUDTapaControler.class);
	
	@Autowired
	@Qualifier("tapaService")
	private  ServicioTapa servicioT;
	
//	@Autowired
//	@Qualifier("precioService")
	private Services <Precio, PrecioModel> servicioP;
	
	@GetMapping("tapa/datos")
	private String crear(Model model)
	{
		
	//	if(model==null) {//hay q pasar las tablas relacionadas
			model.addAttribute("tapaModel", new TapaModel());
			LOG.info("--  insertar datos para la creación de una tapa " + model.toString());
//		}
//		else {
//			LOG.info("--  insertar datos para la modificacion de una tapa ");
//		}
		
		return Constantes.CREAR_TAPA;
	}
	
	@GetMapping("tapa/crear")
	public ModelAndView crear(@Valid @ModelAttribute(name="tapaModel") TapaModel tm, Model model,BindingResult result ) {
		LOG.info("--  crear tapa " + tm.toString());
		ModelAndView mav = new ModelAndView(Constantes.LISTAR_TAPA);
		//modificar crear
		if(result.hasErrors()) {
			mav.setViewName(Constantes.REDIRECT +Constantes.CREAR_TAPA);
		}
		else {
			//llamamos a los servicios
		}
		
		return mav;
	}
}
