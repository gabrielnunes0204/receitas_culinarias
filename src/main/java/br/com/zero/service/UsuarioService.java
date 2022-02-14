package br.com.zero.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.zero.model.Usuario;
import br.com.zero.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository userRepository;
	
	public Usuario criarUsuario(String login, String senha, String nome, String sobrenome) {
		return new Usuario(login, senha, nome, sobrenome);
	}
	
	public Usuario getUsuario(Optional<Usuario> usuario) {
		return usuario.get();
	}
	
	public Usuario getUsuario(Long id) {
		return userRepository.getById(id);
	}
	
	public Usuario create(Usuario user) {
		return userRepository.save(user);
	}
	
	public boolean deleteByUsuario(Usuario usuario) {
		if (usuario != null) {
			userRepository.delete(usuario);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteById(Long id) {
		if (id != null && id > 0) {
			userRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public Usuario update(Usuario usuario) {
		if (usuario != null) {
			if (!usuario.getLogin().equals("") && !usuario.getSenha().equals("") &&
				!usuario.getNome().equals("") && !usuario.getSobrenome().equals("")) {
				return userRepository.save(usuario);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public Usuario findByLoginAndSenha(String login, String senha) {
		if (!login.equals("") && !senha.equals("")) {
			return userRepository.findByLoginAndSenha(login, senha);
		} else {
			return null;
		}
	}
	
	public Usuario findById(Long id) {
		if (id != null && id > 0) {
			try {
				return getUsuario(userRepository.findById(id));
			} catch (NoSuchElementException e) {
				return null;
			}
		} else {
			return null;
		}
	}
}
