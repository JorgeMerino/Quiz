package tfg.quiz.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tfg.quiz.objetoNegocio.Pregunta;
import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.servicioAplicacion.SAPregunta;
import tfg.quiz.servicioAplicacion.SAReto;

@Controller
public class Controlador {
	@Autowired
	private SAReto saReto;
	@Autowired
	private SAPregunta saPregunta;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView mostrarInicio() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/crear-reto", method = RequestMethod.GET)
	public ModelAndView mostrarCrearReto() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("crearReto");
		return modelAndView;
	}
	
	@RequestMapping(value="/crear-reto", method = RequestMethod.POST)
	public ModelAndView crearReto(String nombreReto) {
		Reto reto = new Reto(nombreReto);
		saReto.crear(reto);
		return new ModelAndView("redirect:/reto?id=" + reto.getId());
	}
	
	@RequestMapping(value="/reto", method = RequestMethod.GET)
	public ModelAndView mostrarReto(int id) {
		ModelAndView modelAndView = new ModelAndView();
		Reto reto = saReto.buscar(id);
		modelAndView.addObject("reto", reto);
		modelAndView.addObject("pregunta", new Pregunta());
		modelAndView.setViewName("mostrarReto");
		return modelAndView;
	}
	
	@RequestMapping(value="/reto/{idReto}/nueva-pregunta", method = RequestMethod.POST)
	public ModelAndView nuevaPregunta(@PathVariable("idReto") int idReto, @ModelAttribute("pregunta") Pregunta pregunta) {
		Reto reto = saReto.buscar(idReto);
		pregunta.setReto(reto);
		saPregunta.crear(pregunta);
		return new ModelAndView("redirect:/reto?id=" + reto.getId());
	}
	
	@RequestMapping(value="/reto/{idReto}/lanzar", method = RequestMethod.POST)
	public ModelAndView lanzarReto(@PathVariable("idReto") int idReto) {
		//Mandar reto al tfg
		
		return new ModelAndView("redirect:/reto?id=" + idReto);
	}
	
	@RequestMapping(value="/reto/{idReto}/resolver", method = RequestMethod.GET)
	public ModelAndView resolverReto(@PathVariable("idReto") int idReto) {
		ModelAndView modelAndView = new ModelAndView();
		Reto reto = saReto.buscar(idReto);
		modelAndView.addObject("reto", reto);
		modelAndView.setViewName("resolverReto");
		return modelAndView;
	}
}
