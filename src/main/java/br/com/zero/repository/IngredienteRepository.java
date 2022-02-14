package br.com.zero.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.zero.model.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
	
	//Optional<Ingrediente> findByNomeOptional(String nome);
	//Optional<Ingrediente> findById(Long id);
	
	@Query("Select i From Ingrediente i where i.id = ?1")
	Optional<Ingrediente> findById(Long id);
	
	@Query("Select i From Ingrediente i where i.nome = ?1")
	Ingrediente findByNome(String nome);
}
