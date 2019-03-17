package es.PARebeca.proyectoST_06.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.PARebeca.proyectoST_06.constantes.Constantes;
import es.PARebeca.proyectoST_06.entity.Tapa;
import es.PARebeca.proyectoST_06.model.TapaModel;
import es.PARebeca.proyectoST_06.service.interfaces.Services;
import es.PARebeca.proyectoST_06.service.interfaces.ServicioTapa;

@Controller("proyectoST/sorteo*")
public class sorteoControler {

	private static final Logger LOG = LoggerFactory.getLogger(CRUDTapaControler.class);

	@Autowired
	@Qualifier("tapaService")
	private ServicioTapa servicioT;
	
	
	
//	@Autowired
//	@Qualifier("datosEmpresaServicie")
//	private Services<DatosEmpresa, DatosEmpresaModel> servicioDE;
	
	@GetMapping("/sorteoST/sorteo")
	private String sorteo(Model model) {
		LOG.info("-- entrade en sorteoControler.sorteo()");
		
		model.addAttribute("datosEmpresaModel", "El Canalla");
		model.addAttribute("datosEmpresa.logo", "/imgs/logoPq.jpg");
		
		LOG.info("--  salida  en sorteoControler.sorteo()" + model.toString());
		return Constantes.SORTEO;
	//	return "fragments/barraNavegacion";
	}
	
	@GetMapping("/sorteoST/suerte")
	private String suerte(Model model) {
		LOG.info("-- entrade en sorteoControler.suerte()");
		
		//para h2 de la cabecera cuando se cargue x bd hay q quitarlo
		model.addAttribute("datosEmpresaModel", "El Canalla");
		//llamar al servicio de datosEmpresa para cojer los datos
		model.addAttribute("moselTapas",servicioT.sorteo(2, 1, 1));
		
//		LOG.info("--  salida  en sorteoControler.suert()" + model.toString());
		return  Constantes.SORTEO;
		
	}
}
