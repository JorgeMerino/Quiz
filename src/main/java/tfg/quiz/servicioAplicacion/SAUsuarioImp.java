package tfg.quiz.servicioAplicacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.objetoNegocio.Rol;
import tfg.quiz.objetoNegocio.Usuario;
import tfg.quiz.repositorio.RepositorioUsuario;

@Service("saUsuario")
public class SAUsuarioImp implements SAUsuario{
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Override
	public void crear(Usuario usuario) {
		repositorioUsuario.save(usuario);
	}

	@Override
	public Usuario buscar(int id) {
		return repositorioUsuario.findById(id);
	}

	@Override
	public List<Usuario> buscarParticipantes(Reto reto) {
		List<Usuario> usuarios = repositorioUsuario.findByReto(reto, Rol.Alumno);
		for(int i = 0; i < usuarios.size(); i++) {
			usuarios.get(i).setRespuestas(null);
			usuarios.get(i).setRetos(null);
		}
		
		return usuarios;
	}

	@Override
	public Map<String, String> comprobarUsuario(int id, String token) {
		Gson gson = new Gson(); 
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://localhost:8080/api/comprobar-usuario?idUsuario=" + id + "&token=" + token, String.class);
		System.out.println(result);
		Map<String,String> map = new HashMap<String,String>();
		map = (Map<String,String>) gson.fromJson(result, map.getClass());
		
		return map;
	}
}
