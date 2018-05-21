package tfg.quiz.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tfg.quiz.objetoNegocio.Pregunta;
import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.objetoNegocio.Usuario;

public class DTOReto {
	private int id;
	private String nombre;
	private int grupo;
	private List<Pregunta> preguntas;
	private Set<Usuario> usuarios = new HashSet<>();	
	private Integer idPreguntaActual;
	
	public static DTOReto toDTO(Reto reto) {
		DTOReto dtoReto = new DTOReto();
		dtoReto.setId(reto.getId());
		dtoReto.setNombre(reto.getNombre());
		dtoReto.setPreguntas(reto.getPreguntas());
		dtoReto.setUsuarios(reto.getUsuarios());
		dtoReto.setIdPreguntaActual(reto.getIdPreguntaActual());
		return dtoReto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Integer getIdPreguntaActual() {
		return idPreguntaActual;
	}

	public void setIdPreguntaActual(Integer idPreguntaActual) {
		this.idPreguntaActual = idPreguntaActual;
	}
}
