package tfg.quiz.servicioAplicacion;

import tfg.quiz.objetoNegocio.Reto;

public interface SAReto {
	public void crear(Reto reto);
	public Reto buscar(int id);
	public void buscarTodos();
	public void eliminar(Reto reto);
	public void lanzar(Reto reto);
}
