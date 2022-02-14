package br.com.zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.zero.model.Preparo;
import br.com.zero.service.PreparoService;

@Controller
@RequestMapping("/")
public class PreparoController {

	@Autowired
	PreparoService preparoService;
	
	@GetMapping("preparos")
	public String preparo(Model model) {
		return "preparos";
	}
	
	@PostMapping("cadastrarPreparo")
	public String create(@ModelAttribute("preparos") Preparo preparo, RedirectAttributes redirAttrs) {
		Preparo p = new Preparo(preparo.getNome(), preparo.getTempoPreparo(), preparo.getRendimento());
		preparoService.create(p);
		redirAttrs.addFlashAttribute("sucessoCadastro", "Preparo cadastrado com sucesso!");
		
		return "redirect:/preparos";
	}
	
	@PostMapping("editarPreparo")
	public String update(@ModelAttribute("preparos") Preparo preparo, RedirectAttributes redirAttrs) {
		preparoService.update(preparo, preparo.getId());
		redirAttrs.addFlashAttribute("sucessoEdicao", "Preparo atualizado com sucesso!");
		
		return "redirect:/preparos";
	}
	
	@PostMapping("excluirPreparo")
	public String delete(@ModelAttribute("preparos") Preparo preparo, RedirectAttributes redirAttrs) {
		preparoService.deleteByPreparo(preparo);
		redirAttrs.addFlashAttribute("sucessoExclusao", "Preparo excluído com sucesso!");
		
		return "redirect:/preparos";
	}
}
