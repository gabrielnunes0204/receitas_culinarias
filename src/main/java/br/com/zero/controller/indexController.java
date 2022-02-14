package br.com.zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.zero.model.Usuario;
import br.com.zero.service.UsuarioService;
import br.com.zero.utils.Const;

@Controller
@RequestMapping("/")
public class indexController {
	
	@Autowired
	UsuarioService userService;
	
	@GetMapping
	public String index(Model model) {
		return "index";
	}

	@PostMapping("areaLogado")
	public String logarCliente(@ModelAttribute("login") String login, @ModelAttribute("senha") String senha, RedirectAttributes redirAttrs) {
		Usuario u = userService.findByLoginAndSenha(login, senha);
		
		if (u != null) {
			Const.ID_CLIENTE_LOGADO = u.getId();			
			return "redirect:/areaLogado";
		} else {
			redirAttrs.addFlashAttribute("erro", "Usuário não encontrado!");
			return "redirect:/";
		}
	}
}
