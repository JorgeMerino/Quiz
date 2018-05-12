package tfg.quiz.servicioAplicacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Usuario> buscarParticipantes() {
		return repositorioUsuario.findAll();
	}

}
