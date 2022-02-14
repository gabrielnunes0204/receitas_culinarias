package br.com.zero.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.zero.model.Preparo;

@Repository
public interface PreparoRepository extends JpaRepository<Preparo, Long> {
	
	//Optional<Preparo> findByNomeOptional(String nome);
	//Optional<Preparo> findById(Long id);		
	
	@Query("Select p From Preparo p where p.id = ?1")
	Optional<Preparo> findById(Long id);
	
	@Query("Select p From Preparo p where p.nome = ?1")
	Preparo findByNome(String nome);
}
