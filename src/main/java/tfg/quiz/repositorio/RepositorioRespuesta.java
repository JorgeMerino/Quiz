package tfg.quiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfg.quiz.objetoNegocio.Respuesta;

@Repository("repositorioRespuesta")
public interface RepositorioRespuesta extends JpaRepository<Respuesta, Integer> {

}
