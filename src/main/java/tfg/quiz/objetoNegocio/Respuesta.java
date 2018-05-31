package tfg.quiz.objetoNegocio;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "respuestas")
public class Respuesta{
	@EmbeddedId
	private RespuestaId id;

	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUsuario")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idPregunta")
	private Pregunta pregunta;
	
	private int tiempo;
	
	private Integer idOpcionMarcada;
	 
    public Respuesta(Usuario usuario, Pregunta pregunta) {
        this.usuario = usuario;
        this.pregunta = pregunta;
        this.id = new RespuestaId(usuario.getId(), pregunta.getId());
    }
    
    public Respuesta() {}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Respuesta that = (Respuesta) o;
        return Objects.equals(usuario, that.usuario) &&
               Objects.equals(pregunta, that.pregunta);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(usuario, pregunta);
    }

	public RespuestaId getId() {
		return id;
	}

	public void setId(RespuestaId id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public Integer getIdOpcionMarcada() {
		return idOpcionMarcada;
	}

	public void setIdOpcionMarcada(Integer idOpcionMarcada) {
		this.idOpcionMarcada = idOpcionMarcada;
	}
}
