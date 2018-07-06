package tfg.quiz.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.servicioAplicacion.SARespuesta;
import tfg.quiz.servicioAplicacion.SAReto;

@Controller
@RequestMapping(value="/api")
public class QuizControladorAPI {
	@Autowired
	private SAReto saReto;
	@Autowired
	private SARespuesta saRespuesta;
	
	@RequestMapping(value="/reto/{idReto}/crear", method = RequestMethod.POST)
	@ResponseBody
	public void crearReto(@PathVariable("idReto") int idReto, String nombre) {
		Reto reto = new Reto(idReto, nombre);
		saReto.crear(reto);
	}
	
	@RequestMapping(value="/reto/{idReto}/resultados", method = RequestMethod.GET)
	@ResponseBody
	public String obtenerResultados(@PathVariable("idReto") int idReto) {
		Reto reto = saReto.buscar(idReto);
		return saRespuesta.obtenerJsonRespuestas(reto);
	}
	
	@RequestMapping(value="/reto/eliminar", method = RequestMethod.POST)
	@ResponseBody
	public void eliminarReto(int id) {
		Reto reto = saReto.buscar(id);
		saReto.eliminar(reto);
	}
}
