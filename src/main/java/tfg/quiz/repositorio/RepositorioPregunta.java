package tfg.quiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfg.quiz.objetoNegocio.Pregunta;

@Repository("repositorioPregunta")
public interface RepositorioPregunta extends JpaRepository<Pregunta, Integer> {

	Pregunta findById(int id);

}
