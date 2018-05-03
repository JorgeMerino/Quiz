package tfg.quiz.objetoNegocio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "preguntas")
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reto")
	private Reto reto;
	
	@NotNull
	private String opcionA;
	
	@NotNull
	private String opcionB;
	
	@NotNull
	private String opcionC;
	
	@NotNull
	private String opcionD;
	
	@NotNull
	private Opcion correcta;

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

	public Reto getReto() {
		return reto;
	}

	public void setReto(Reto reto) {
		this.reto = reto;
	}

	public String getOpcionA() {
		return opcionA;
	}

	public void setOpcionA(String opcionA) {
		this.opcionA = opcionA;
	}

	public String getOpcionB() {
		return opcionB;
	}

	public void setOpcionB(String opcionB) {
		this.opcionB = opcionB;
	}

	public String getOpcionC() {
		return opcionC;
	}

	public void setOpcionC(String opcionC) {
		this.opcionC = opcionC;
	}

	public String getOpcionD() {
		return opcionD;
	}

	public void setOpcionD(String opcionD) {
		this.opcionD = opcionD;
	}

	public Opcion getCorrecta() {
		return correcta;
	}

	public void setCorrecta(Opcion correcta) {
		this.correcta = correcta;
	}
}
