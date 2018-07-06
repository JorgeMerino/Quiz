package tfg.quiz.servicioAplicacion;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import tfg.quiz.objetoNegocio.Respuesta;
import tfg.quiz.objetoNegocio.Reto;

public interface SARespuesta {
	public void crear(Respuesta respuesta);
	public String obtenerJsonRespuestas(Reto reto);
	public void exportar(Reto reto) throws ClientProtocolException, IOException;
}
