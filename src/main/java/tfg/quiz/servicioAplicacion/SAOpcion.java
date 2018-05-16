package tfg.quiz.servicioAplicacion;

import tfg.quiz.objetoNegocio.Opcion;

public interface SAOpcion {
	public void crear(Opcion opcion);
	
	public Opcion buscar(int id);

}
