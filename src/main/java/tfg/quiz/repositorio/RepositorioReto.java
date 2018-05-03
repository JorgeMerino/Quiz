package tfg.quiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfg.quiz.objetoNegocio.Reto;

@Repository("repositorioReto")
public interface RepositorioReto extends JpaRepository<Reto, Integer> {
	Reto findById(int id);
}
