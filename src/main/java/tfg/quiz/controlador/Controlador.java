package tfg.quiz.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tfg.quiz.dto.DTOReto;
import tfg.quiz.objetoNegocio.Opcion;
import tfg.quiz.objetoNegocio.Pregunta;
import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.servicioAplicacion.SAOpcion;
import tfg.quiz.servicioAplicacion.SAPregunta;
import tfg.quiz.servicioAplicacion.SAReto;

@Controller
public class Controlador {
	@Autowired
	private SAReto saReto;
	@Autowired
	private SAPregunta saPregunta;
	@Autowired
	private SAOpcion saOpcion;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView mostrarInicio(int idAsignatura) {
		ModelAndView modelAndView = new ModelAndView();
		DTOReto dtoReto = new DTOReto();
		dtoReto.setGrupo(idAsignatura);
		modelAndView.addObject("dtoReto", dtoReto);
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value="/reto/{idReto}", method = RequestMethod.GET)
	public ModelAndView mostrarReto(@PathVariable("idReto") int idReto) {
		ModelAndView modelAndView = new ModelAndView();
		Reto reto = saReto.buscar(idReto);
		DTOReto dtoReto = DTOReto.toDTO(reto);
		modelAndView.addObject("dtoReto", dtoReto);
		modelAndView.setViewName("mostrarReto");
		return modelAndView;
	}
	
	@RequestMapping(value="/reto/{idReto}/insertar-pregunta", method = RequestMethod.GET)
	public ModelAndView mostrarInsertarPregunta(@PathVariable("idReto") int idReto, @ModelAttribute("pregunta") Pregunta pregunta) {
		ModelAndView modelAndView = new ModelAndView();
		Reto reto = saReto.buscar(idReto);
		modelAndView.addObject("dtoReto", reto);
		modelAndView.addObject("pregunta", new Pregunta());
		modelAndView.addObject("opcion", new Opcion());
		modelAndView.setViewName("insertarPregunta");
		return modelAndView;
	}
	
	@RequestMapping(value="/reto/{idReto}/insertar-pregunta", method = RequestMethod.POST)
	public ModelAndView insertarPregunta(@PathVariable("idReto") int idReto, @RequestParam Map<String, String> parametros) {
		Reto reto = saReto.buscar(idReto);
		Pregunta pregunta = new Pregunta();
		pregunta.setCuestion(parametros.get("nombrePregunta"));
		pregunta.setReto(reto);		
		saPregunta.crear(pregunta);
		
		List<Opcion> opciones = new ArrayList<Opcion>();
		Opcion opcion;
		int idOpcion;
		
		for(String parametro : parametros.keySet()) {
			opcion = new Opcion();
			if(parametro.startsWith("nombreOpcion")) {
				idOpcion = Integer.parseInt(parametro.replaceAll("nombreOpcion", ""));
				opcion.setRespuesta(parametros.get(parametro));
				opcion.setPregunta(pregunta);
				if(idOpcion != Integer.parseInt(parametros.get("customRadio").replaceAll("opcionCorrecta", ""))) {
					opcion.setCorrecta(false);
				}
				else {
					opcion.setCorrecta(true);
				}	
				opciones.add(opcion);
			}
		}
		
		for(Opcion o : opciones) {
			saOpcion.crear(o);
		}
		
		return new ModelAndView("redirect:/reto/" + reto.getId());
	}
	
	@RequestMapping(value="/reto/{idReto}/eliminar-pregunta", method = RequestMethod.POST)
	public ModelAndView eliminarPregunta(@PathVariable("idReto") int idReto, int idPregunta) {
		Reto reto = saReto.buscar(idReto);
		Pregunta pregunta = saPregunta.buscar(idPregunta);
		saPregunta.eliminar(pregunta);
		
		return new ModelAndView("redirect:/reto/" + reto.getId());
	}
	
	
	
	@RequestMapping(value="/reto/{idReto}/resolver", method = RequestMethod.GET)
	public ModelAndView resolverReto(@PathVariable("idReto") int idReto,
			int idAlumno ) {
		ModelAndView modelAndView = new ModelAndView();
		Reto reto = saReto.buscar(idReto);
		modelAndView.addObject("reto", reto);
		modelAndView.addObject("idAlumno", idAlumno);
		modelAndView.setViewName("resolverReto");
		return modelAndView;
	}
}
