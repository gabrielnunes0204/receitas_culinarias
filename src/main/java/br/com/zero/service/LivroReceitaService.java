package br.com.zero.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.zero.model.LivroReceita;
import br.com.zero.repository.LivroReceitaRepository;

@Service
public class LivroReceitaService {
	
	@Autowired
	LivroReceitaRepository livroRepository;
		
	public LivroReceita criarLivro(String nome, String categoria) {
		return new LivroReceita(nome, categoria);
	}
	
	public LivroReceita getLivro(Optional<LivroReceita> livros) {
		return livros.get();
	}
	
	public LivroReceita create(LivroReceita livro) {
		return livroRepository.save(livro);
	}
	
	public boolean deleteByLivro(LivroReceita livro) {
		if (livro != null) {
			livroRepository.delete(livro);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteById(Long id) {
		if (id != null && id > 0) {
			livroRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public LivroReceita update(LivroReceita l, Long id) {
		Optional<LivroReceita> found = livroRepository.findById(id);
		
		found.get().setNome(l.getNome());
		found.get().setCategoria(l.getCategoria());
		
		return livroRepository.save(l);
	}
	
	public LivroReceita findByNome(String nome) {
		if (!nome.equals("")) {
			return livroRepository.findByNome(nome);
		} else {
			return null;
		}
	}
	
	public LivroReceita findById(Long id) {
		if (id != null && id > 0) {
			try {
				return getLivro(livroRepository.findById(id));
			} catch (NoSuchElementException e) {
				return null;
			}
		} else {
			return null;
		}
	}
}
