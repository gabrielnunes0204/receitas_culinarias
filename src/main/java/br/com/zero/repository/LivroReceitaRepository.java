package br.com.zero.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.zero.model.LivroReceita;

@Repository
public interface LivroReceitaRepository extends JpaRepository<LivroReceita, Long> {
	
	//Optional<LivroReceita> findByNomeOptional(String nome);
	//Optional<LivroReceita> findById(Long id);
	
	@Query("Select l From LivroReceita l where l.id = ?1")
	Optional<LivroReceita> findById(Long id);
	
	@Query("Select l From LivroReceita l where l.nome = ?1")
	LivroReceita findByNome(String nome);
}
