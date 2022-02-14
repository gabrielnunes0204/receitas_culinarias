package br.com.zero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.zero.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//Optional<Usuario> findByLoginAndSenhaOptional(String login, String senha);
	
	@Query("Select u From Usuario u where u.login = ?1 and u.senha = ?2")
	Usuario findByLoginAndSenha(String login, String senha);
}
