package tfg.quiz.servicioAplicacion;

import java.util.List;

import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.objetoNegocio.Usuario;

public interface SAUsuario {
	public void crear(Usuario usuario);
	public Usuario buscar(int id);
	public List<Usuario> buscarParticipantes(Reto reto);
	
	public boolean comprobarUsuario(int id, String token);
}
