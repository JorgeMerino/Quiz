package tfg.quiz.objetoNegocio;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "preguntas")
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	private String cuestion;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reto")
	private Reto reto;
	
	@OneToMany(
		mappedBy = "pregunta", 
		cascade = CascadeType.ALL, 
		orphanRemoval = true
	)
	private List<Opcion> opciones;
	
	@OneToMany(mappedBy = "pregunta",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Respuesta> respuestas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuestion() {
		return cuestion;
	}

	public void setCuestion(String cuestion) {
		this.cuestion = cuestion;
	}

	public Reto getReto() {
		return reto;
	}

	public void setReto(Reto reto) {
		this.reto = reto;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}
	
	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
}
