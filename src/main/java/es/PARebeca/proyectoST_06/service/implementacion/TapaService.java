package es.PARebeca.proyectoST_06.service.implementacion;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
		LOG.info("-- tapaServicio.sorteo()");
		
		List<Tapa> tapasServidas =repositorio.buscarTapasServias();
		List<Tapa> tapasNoServidas = repositorio.buscarTapasNoservidas();
		List<Tapa> tapasPalillo= new ArrayList<>();
		List<Tapa> tapasCuchara= new ArrayList<>();
		List<Tapa> tapaSorteo= new ArrayList<>();
		int tiradasPalillo =nTapasPalillo* nDias;
		int tiradasCuchara = nTapasCuchara* nDias;
		
		// # no hay tapas sin servir si servidas
		if(tapasNoServidas.isEmpty() && !tapasServidas.isEmpty() ){

			// cambiamos el estado y cargamos las listas para el sorteo
			for (Tapa tapa : tapasServidas) {
				tapa.setServida(false);
				if(tapa.getTipo().toString().equals("cuchara")) {
					tapasCuchara.add(tapa);
				}
				if(tapa.getTipo().toString().equals("palillo")) {
					tapasPalillo.add(tapa);
				}
			}
			//lamammos soteo
			tapaSorteo= tirada(tapasCuchara, tiradasCuchara );
			tapaSorteo.addAll( tirada( tapasPalillo, tiradasPalillo ));

		}	
		
		// # hay tapas sin servir
		if(!tapasNoServidas.isEmpty()) {
			
			//separamos las listas de las tapas q aun no han sido servidas
			for (Tapa tapa : tapasNoServidas) {
				
				if(tapa.getTipo().toString().equals("cuchara")) {
					tapasCuchara.add(tapa);
				}
				if(tapa.getTipo().toString().equals("palillo")) {
					tapasPalillo.add(tapa);
				}
			}
		
			// # != posibilidades tapaCuchara
			if(tapasCuchara.size()> tiradasCuchara) {
				//sorteo
				tapaSorteo= tirada(tapasCuchara, tiradasCuchara );
			}
			
			if(tapasCuchara.size()== tiradasCuchara) {
				//asignamos directament
				tapaSorteo.addAll(tapasCuchara);
			}
			
			if(tapasCuchara.size()< tiradasCuchara) {
				
				//guardamos las q hay. van directas
				tapaSorteo.addAll(tapasCuchara);
				
				//comprobamos si hay tapas ya servidas 
				if(!tapasServidas.isEmpty()) {
					//cambiar Estado
					for (Tapa tapa : tapasServidas) {

						if(tapa.getTipo().toString().equals("cuchara") && tapa.isServida() ) {
							tapa.setServida(false);
							tapasCuchara.add(tapa);	
						}
					}
					if(tapasCuchara.size()+ tapaSorteo.size()> tiradasCuchara) {
						tapaSorteo= tirada(tapasCuchara, tiradasCuchara );
					}
					else {
						// excepcion insuficientes tapasCuchara
					}
					
				}
				else {
					//excepcion insuficientes tapasCuchara
				}
			}
			
			// # != posibilidades tapaCuchara
			if(tapasPalillo.size()> tiradasPalillo) {
				//sorteo
				tapaSorteo.addAll( tirada( tapasPalillo, tiradasPalillo ));
			}
			if(tapasPalillo.size()== tiradasPalillo) {
				//asignamos directament
				tapaSorteo.addAll( tapasPalillo);
			}
			if(tapasPalillo.size()< tiradasPalillo) {
				
				//guardamos las q hay. van directas
				tapaSorteo.addAll(tapasPalillo);
				
				//comprobamos si hay tapas ya servidas 
				if(!tapasServidas.isEmpty()) {
					//cambiar Estado
					for (Tapa tapa : tapasServidas) {

						if(tapa.getTipo().toString().equals("palillo") && tapa.isServida()) {
							tapa.setServida(false);
							tapasPalillo.add(tapa);	
						}
					}
					if(tapasPalillo.size()+ tapaSorteo.size()> tiradasPalillo) {
						tapaSorteo= tirada(tapasPalillo, tiradasPalillo );
					}
					else {
						// excepcion insuficientes tapasPalillo
					}
					
				}
				else {
					//excepcion insuficientes tapasPalillo
				}
			
			}
		
		}	
		
	
		return tapaSorteo;
	}

	private List<Tapa> tirada(List<Tapa> tapas, int tiradas) {
		List<Tapa> tapasS = new ArrayList<>();
		//comparamos los numeros, no las tapas
		List<Integer> arrai = new ArrayList<>();
		int n =0;
		int i=0;
		boolean existe= false;
		
		
		n= (int) (Math.random()*tapas.size());
		
		arrai.add(n);
		tapas.get(n).setServida(true);
		tapasS.add(tapas.get(n));
		
		while (arrai.size() < tiradas) {
			System.out.println("   --- antes     tamaño de array tapas "+arrai.size());
			n= (int) (Math.random()*tapas.size());
			existe=false;
			
			while (!existe && (i<arrai.size())) {
				System.out.println("   ---     tamaño de array despues "+arrai.size() +"  i"+i);	
				if(arrai.get(i)==n) {
					existe= true;
				}
				i++;
			}
			if(!existe) {
				arrai.add(n);
				tapas.get(n).setServida(true);
				tapasS.add(tapas.get(n));
			}
		}
		
		return tapasS;
	
	}

	

}
