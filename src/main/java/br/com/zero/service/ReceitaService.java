package br.com.zero.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.zero.model.Receita;
import br.com.zero.repository.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired()
	ReceitaRepository receitaRepository;
	
	public Receita criarReceita(String nome, String descricao) {
		return new Receita(nome, descricao);
	}
	
	private Receita getReceita(Optional<Receita> receitas) {
		return receitas.get();
	}
	
	public Receita create(Receita receita) {
		return receitaRepository.save(receita);
	}
	
	public boolean deleteReceita(Receita receita) {
		if (receita != null) {
			receitaRepository.delete(receita);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteById(Long id) {
		if (id != null && id > 0) {
			receitaRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public Receita update(Receita r, Long id) {
		Optional<Receita> found = receitaRepository.findById(id);
		found.get().setNome(r.getNome());
		found.get().setDescricao(r.getDescricao());
		
		return receitaRepository.save(r);
	}
	
	public Receita findByNome(String nome) {
		if (!nome.equals("")) {
			return receitaRepository.findByNome(nome);
		} else {
			return null;
		}
	}
	
	public Receita findById(Long id) {
		if (id != null && id > 0) {
			try {
				return getReceita(receitaRepository.findById(id));
			} catch (NoSuchElementException e) {
				return null;
			}
		} else
			return null;
	}
}
