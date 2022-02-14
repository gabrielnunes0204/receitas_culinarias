package br.com.zero.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.zero.model.Ingrediente;
import br.com.zero.repository.IngredienteRepository;

@Service
public class IngredienteService {
	@Autowired
	IngredienteRepository ingredienteRepository;

	public Ingrediente criarIngrediente(String nome, Integer quantidade) {
		return new Ingrediente(nome, quantidade);
	}

	public Ingrediente getIngrediente(Optional<Ingrediente> ingrediente) {
		return ingrediente.get();
	}

	public Ingrediente create(Ingrediente ingrediente) {
		return ingredienteRepository.save(ingrediente);
	}

	public boolean deleteByIngrediente(Ingrediente ingrediente) {
		if (ingrediente != null) {
			ingredienteRepository.delete(ingrediente);
			return true;
		}
		return false;
	}

	public boolean deleteIngredienteById(Long id) {
		if (id != null && id > 0) {
			ingredienteRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Ingrediente update(Ingrediente i, Long id) {
		Optional<Ingrediente> found = ingredienteRepository.findById(id);
		
		found.get().setNome(i.getNome());
		found.get().setQuantidade(i.getQuantidade());
		
		return ingredienteRepository.save(i);
	}
	
	public Ingrediente findByNome(String nome) {
		if (!nome.equals("")) {
			return ingredienteRepository.findByNome(nome);
		} else {
			return null;
		}
	}

	public Ingrediente findById(Long id) {
		if (id != null && id > 0) {
			try {
				return getIngrediente(ingredienteRepository.findById(id));
			} catch (NoSuchElementException e) {
				return null;
			}
		} else
			return null;
	}
}
