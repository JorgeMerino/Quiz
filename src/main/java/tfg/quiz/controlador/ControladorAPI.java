package tfg.quiz.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.servicioAplicacion.SAReto;

@Controller
@RequestMapping(value="/api")
public class ControladorAPI {
	@Autowired
	private SAReto saReto;
	
	@RequestMapping(value="/reto/crear", method = RequestMethod.POST)
	public void crearReto(String nombre) {
		Reto reto = new Reto(nombre);
		saReto.crear(reto);
	}
	
	@RequestMapping(value="/reto/eliminar", method = RequestMethod.POST)
	public void eliminarReto(int id) {
		Reto reto = saReto.buscar(id);
		saReto.eliminar(reto);
	}
}
