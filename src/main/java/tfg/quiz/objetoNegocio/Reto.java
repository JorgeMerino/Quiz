package tfg.quiz.objetoNegocio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "retos")
public class Reto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	private String nombre;
	
	@OneToMany(
		mappedBy = "reto", 
		cascade = CascadeType.ALL, 
		orphanRemoval = true
	)
	private Set<Pregunta> preguntas;
	
	public Reto() {
		this.preguntas = new HashSet<Pregunta>();
	}
	
	public Reto(String nombre) {
		this.nombre = nombre;
		this.preguntas = new HashSet<Pregunta>();
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

	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
}
