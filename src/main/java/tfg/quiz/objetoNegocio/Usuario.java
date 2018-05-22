package tfg.quiz.objetoNegocio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	private int id;
	
	private String nick;
	
	@ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "usuario_reto",
        joinColumns = @JoinColumn(name = "usuario"),
        inverseJoinColumns = @JoinColumn(name = "reto")
    )
    private Set<Reto> retos = new HashSet<>();
	
	@OneToMany(mappedBy = "usuario",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Respuesta> respuestas;
	
	public Usuario(int id) {
		this.id = id;
		this.respuestas = new HashSet<Respuesta>();
	}
	
	public Usuario() {
		this.respuestas = new HashSet<Respuesta>();
	}
	
	public void insertarReto(Reto reto) {
		this.retos.add(reto);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Set<Reto> getRetos() {
		return retos;
	}

	public void setRetos(Set<Reto> retos) {
		this.retos = retos;
	}

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
}
