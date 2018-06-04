package tfg.quiz.servicioAplicacion;

import java.util.List;
import java.util.Map;

import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.objetoNegocio.Usuario;

public interface SAUsuario {
	public void crear(Usuario usuario);
	public Usuario buscar(int id);
	public List<Usuario> buscarParticipantes(Reto reto);
	
	public Map<String, String> comprobarUsuario(int id, String token);
}
