package es.PARebeca.proyectoST_06.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import es.PARebeca.proyectoST_06.entity.DatosEmpresa;
import es.PARebeca.proyectoST_06.service.interfaces.Services;

@Controller("proyectoST/*")
public class sorteoControler {

	private static final Logger LOG = LoggerFactory.getLogger(CRUDTapaControler.class);

	@Autowired
	@Qualifier("datosEmpresaServicie")
	private Services<DatosEmpresa, DatosEmpresaModel> servicioDE;
	
	@GetMapping("/sorteo")
}
