package br.com.zero.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.zero.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
	
	//Optional<Receita> findByNomeOptional(String nome);
	//Optional<Receita> findById(Long id);
	
	@Query("Select r From Receita r where r.id = ?1")
	Optional<Receita> findById(Long id);
	
	@Query("Select r From Receita r where r.nome = ?1")
	Receita findByNome(String nome);
}
