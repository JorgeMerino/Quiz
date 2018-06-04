package tfg.quiz.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tfg.quiz.objetoNegocio.Reto;
import tfg.quiz.objetoNegocio.Rol;
import tfg.quiz.objetoNegocio.Usuario;

@Repository("repositorioUsuario")
public interface RepositorioUsuario  extends JpaRepository<Usuario, Integer> {

	Usuario findById(int id);
	
	@Query("SELECT usuario FROM Usuario usuario JOIN usuario.retos reto WHERE reto = :reto AND usuario.rol = :rol")
	List<Usuario> findByReto(@Param("reto") Reto reto, @Param("rol") Rol rol);

}
