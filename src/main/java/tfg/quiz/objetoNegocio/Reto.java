package tfg.quiz.objetoNegocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import tfg.quiz.dto.DTOReto;

@Entity
@Table(name = "retos")
public class Reto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	private String nombre;
	
	private boolean disponible;
	
	@OneToMany(
		mappedBy = "reto", 
		cascade = CascadeType.ALL, 
		orphanRemoval = true
	)
	private List<Pregunta> preguntas;
	
	private Integer idPreguntaActual;
	
	public Reto() {
		this.disponible = false;
		this.preguntas = new ArrayList<Pregunta>();
		this.idPreguntaActual = null;
	}
	
	public Reto(String nombre) {
		this.nombre = nombre;
		this.disponible = false;
		this.preguntas = new ArrayList<Pregunta>();
		this.idPreguntaActual = null;
	}
	
	public static Reto toObjetoNegocio(DTOReto dtoReto) {
		Reto reto = new Reto();
		reto.setId(dtoReto.getId());
		reto.setNombre(dtoReto.getNombre());
		reto.setPreguntas(dtoReto.getPreguntas());
		return reto;
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

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Integer getIdPreguntaActual() {
		return idPreguntaActual;
	}

	public void setIdPreguntaActual(Integer idPreguntaActual) {
		this.idPreguntaActual = idPreguntaActual;
	}
}
