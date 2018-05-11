package tfg.quiz.servicioAplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.repositorio.RepositorioReto;

@Service("SAReto")
public class SARetoImp implements SAReto {
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
}
