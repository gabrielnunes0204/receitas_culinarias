package br.com.zero.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.zero.model.Preparo;
import br.com.zero.repository.PreparoRepository;

@Service
public class PreparoService {

	@Autowired
	PreparoRepository preparoRepository;

	public Preparo criarPreparo(String nome, String rendimento, String tempoPreparo) {
		return new Preparo(nome, tempoPreparo, rendimento);
	}

	public Preparo getPreparo(Optional<Preparo> preparos) {
		return preparos.get();
	}

	public Preparo create(Preparo preparo) {
		return preparoRepository.save(preparo);
	}

	public boolean deleteByPreparo(Preparo preparo) {
		if (preparo != null) {
			preparoRepository.delete(preparo);
			return true;
		}
		return false;
	}

	public boolean deleteById(Long id) {
		if (id != null && id > 0) {
			preparoRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Preparo update(Preparo p, Long id) {
		Optional<Preparo> found = preparoRepository.findById(id);
		found.get().setNome(p.getNome());
		found.get().setTempoPreparo(p.getTempoPreparo());
		found.get().setRendimento(p.getRendimento());
		
		return preparoRepository.save(p);
	}

	public Preparo findByNome(String nome) {
		if (!nome.equals("")) {
			return preparoRepository.findByNome(nome);
		} else
			return null;
	}

	public Preparo findById(Long id) {
		if (id != null && id > 0) {
			try {
				return getPreparo(preparoRepository.findById(id));
			} catch (NoSuchElementException e) {
				return null;
			}
		} else
			return null;
	}
}
