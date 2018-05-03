package tfg.quiz.servicioAplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.quiz.objetoNegocio.Pregunta;
import tfg.quiz.repositorio.RepositorioPregunta;

@Service("SAPregunta")
public class SAPreguntaImp implements SAPregunta {
	@Autowired
	private RepositorioPregunta repositorioPregunta;

	@Override
	public void crear(Pregunta pregunta) {
		repositorioPregunta.save(pregunta);
	}
}
