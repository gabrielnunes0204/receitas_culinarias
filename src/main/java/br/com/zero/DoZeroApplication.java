package br.com.zero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.zero.model.Usuario;
import br.com.zero.service.UsuarioService;

@SpringBootApplication
public class DoZeroApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(DoZeroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario user = new Usuario("gab@gmail.com", "1234", "Gabriel", "Nunes");
		userService.create(user);
	}
}
