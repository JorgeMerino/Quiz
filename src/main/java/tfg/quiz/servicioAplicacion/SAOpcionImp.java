package tfg.quiz.servicioAplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.quiz.objetoNegocio.Opcion;
import tfg.quiz.repositorio.RepositorioOpcion;

@Service("saOpcion")
public class SAOpcionImp implements SAOpcion{
	@Autowired
	private RepositorioOpcion repositorioOpcion;
	
	@Override
	public void crear(Opcion opcion) {
		repositorioOpcion.save(opcion);
	}

	@Override
	public Opcion buscar(int id) {
		return repositorioOpcion.findById(id);
	}

}
