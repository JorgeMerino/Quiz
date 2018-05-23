package tfg.quiz.servicioAplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.repositorio.RepositorioReto;

@Service("SAReto")
public class SARetoImp implements SAReto {
	public static final String baseUrl = "http://localhost:8080";
	
	@Autowired
	private RepositorioReto repositorioReto;

	@Override
	public void crear(Reto reto) {
		repositorioReto.save(reto);		
	}

	@Override
	public Reto buscar(int id) {
		return repositorioReto.findById(id);
	}
	
	@Override
	public void buscarTodos() {
		repositorioReto.findAll();
	}

	@Override
	public void eliminar(Reto reto) {
		repositorioReto.delete(reto);
	}

	@Override
	public void lanzar(Reto reto) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		String url = baseUrl + "/api/reto/" + reto.getId() + "/cambiar-disponibilidad";

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("disponible", "true");
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity( url, request, String.class );
		System.out.println(response);
	}
}
