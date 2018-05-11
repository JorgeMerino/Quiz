package tfg.quiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfg.quiz.objetoNegocio.Opcion;

@Repository("repositorioOpcion")
public interface RepositorioOpcion extends JpaRepository<Opcion, Integer> {

}
