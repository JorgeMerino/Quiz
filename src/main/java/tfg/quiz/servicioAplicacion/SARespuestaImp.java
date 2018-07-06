package tfg.quiz.servicioAplicacion;

import java.io.IOException;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.quiz.objetoNegocio.Opcion;
import tfg.quiz.objetoNegocio.Pregunta;
import tfg.quiz.objetoNegocio.Respuesta;
import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.objetoNegocio.Rol;
import tfg.quiz.objetoNegocio.Usuario;
import tfg.quiz.repositorio.RepositorioRespuesta;

@Service("saRespuesta")
public class SARespuestaImp implements SARespuesta{
	public static final String baseUrl = "http://localhost:9000";
	
	@Autowired
	private RepositorioRespuesta repositorioRespuesta;
	
	@Override
	public void crear(Respuesta respuesta) {
		repositorioRespuesta.save(respuesta);
	}
	
	public String obtenerJsonRespuestas(Reto reto) {
		Set<Respuesta> respuestas;
		String jsonRespuestas;
		int contadorCorrectas, tiempoTotal, tiempoMedio, puntos, porcentajeAciertos;
		Integer opcionCorrecta = 0;
		
		if(reto.getUsuarios().size() <= 1 || reto.getPreguntas().isEmpty()) {
			return "{ usuarios: []}";
		}			
		
		jsonRespuestas = "{ usuarios: [";
		for(Usuario usuario : reto.getUsuarios()) {
			if(usuario.getRol() == Rol.Alumno) {
				contadorCorrectas = 0;
				tiempoTotal = 0;
				tiempoMedio = 0;
				puntos = 0;
				porcentajeAciertos = 0;		
				
				jsonRespuestas += "{usuarioId: " + usuario.getId() +", preguntas: [";
				
				for(Pregunta pregunta : reto.getPreguntas()) {
					respuestas = pregunta.getRespuestas();
					for(Opcion opcion : pregunta.getOpciones()) {
						if(opcion.isCorrecta()) {
							opcionCorrecta = opcion.getId();
						}					
					}
					for(Respuesta respuesta : respuestas) {
						if(usuario.equals(respuesta.getUsuario())) {
							if(respuesta.isCorrecta()) {
								contadorCorrectas++;
							}
							
							tiempoTotal += respuesta.getTiempo();
							jsonRespuestas += "{Pregunta: \"" + pregunta.getCuestion() + "\", " +
											"OpcionCorrecta: \"" + opcionCorrecta + "\", " +
											"IdOpcionMarcada: " + respuesta.getIdOpcionMarcada() + ", " +
											"OpcionMarcada: \"" + respuesta.getOpcionMarcada() + "\", " +
											"Correcta: " + respuesta.isCorrecta() + ", " +
											"Tiempo: " + respuesta.getTiempo() + "},";
						}					
					}
				}	
				
				tiempoMedio = (int)(Math.round(tiempoTotal / usuario.getRespuestas().size()));
				puntos = contadorCorrectas*10;
				porcentajeAciertos = (int)(Math.round(contadorCorrectas * 100 / usuario.getRespuestas().size()));
				
				
				jsonRespuestas = jsonRespuestas.substring(0, jsonRespuestas.length() - 1) + "],";
				jsonRespuestas += "tiempoTotal: " + tiempoTotal + ", " +
						"tiempoMedio: " + tiempoMedio + ", " +
						"puntos: " + puntos + ", " +
						"porcentajeAciertos: " + porcentajeAciertos + "},";
			}
		}
		
		jsonRespuestas = jsonRespuestas.substring(0, jsonRespuestas.length() - 1) + "]}";
		
		return jsonRespuestas;
	}

	@Override
	public void exportar(Reto reto) throws ClientProtocolException, IOException {
		String jsonRespuestas = obtenerJsonRespuestas(reto);		
		StringEntity entity = new StringEntity(jsonRespuestas, ContentType.APPLICATION_JSON);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost peticion = new HttpPost(baseUrl + "/api/reto/" + reto.getId() + "/importar");
        peticion.setEntity(entity);

        HttpResponse respuesta = httpClient.execute(peticion);
        System.out.println(respuesta);
	}
}
