package tfg.quiz.servicioAplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.quiz.objetoNegocio.Respuesta;
import tfg.quiz.repositorio.RepositorioRespuesta;

@Service("saRespuesta")
public class SARespuestaImp implements SARespuesta{
	@Autowired
	private RepositorioRespuesta repositorioRespuesta;
	
	@Override
	public void crear(Respuesta respuesta) {
		repositorioRespuesta.save(respuesta);
	}

}
