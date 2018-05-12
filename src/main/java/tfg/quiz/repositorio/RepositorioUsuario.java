package tfg.quiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfg.quiz.objetoNegocio.Usuario;

@Repository("repositorioUsuario")
public interface RepositorioUsuario  extends JpaRepository<Usuario, Integer> {

	Usuario findById(int id);

}
