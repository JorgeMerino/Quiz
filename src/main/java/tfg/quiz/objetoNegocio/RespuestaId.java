package tfg.quiz.objetoNegocio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RespuestaId implements Serializable {
	private int idUsuario;
    
    private int idPregunta;
 
    private RespuestaId() {}
 
    public RespuestaId(int idUsuario, int idPregunta) {
        this.idUsuario = idUsuario;
        this.idPregunta = idPregunta;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        RespuestaId that = (RespuestaId) o;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(idPregunta, that.idPregunta);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idPregunta);
    }

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
}
