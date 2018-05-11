package tfg.quiz.servicioAplicacion;

import tfg.quiz.objetoNegocio.Pregunta;

public interface SAPregunta {
	public void crear(Pregunta pregunta);
	public Pregunta buscar(int id);
	public void eliminar(Pregunta pregunta);
}
