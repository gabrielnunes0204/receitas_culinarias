package br.com.zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.zero.model.Usuario;
import br.com.zero.service.UsuarioService;
import br.com.zero.utils.Const;

@Controller
@RequestMapping("/")
public class CadastroController {

	@Autowired
	UsuarioService userService;
	
	@GetMapping("cadastro")
	public String index(Model model) {
		return "cadastro";
	}
	
	@PostMapping("cadastroUser")
	public String efetuarCadastro(@ModelAttribute("usuario") Usuario usuario) {
		Usuario user = new Usuario(usuario.getLogin(),
								   usuario.getSenha(),
								   usuario.getNome(),
								   usuario.getSobrenome());
		userService.create(user);
		Const.ID_CLIENTE_LOGADO = user.getId();
				
		return "redirect:/";
	}
}
