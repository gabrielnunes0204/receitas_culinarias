package br.com.zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.zero.model.Receita;
import br.com.zero.service.ReceitaService;

@Controller
@RequestMapping("/")
public class ReceitaController {

	@Autowired
	ReceitaService receitaService;
	
	@GetMapping("receitas")
	public String index(Model model) {
		return "receitas";
	}
	
	@PostMapping("cadastrarReceita")
	public String create(@ModelAttribute("receita") Receita receita, RedirectAttributes redirAttrs) {
		Receita r = new Receita(receita.getNome(), receita.getDescricao());
		receitaService.create(r);
		redirAttrs.addFlashAttribute("sucessoCadastro", "Receita cadastrada com sucesso!");
				
		return "redirect:/receitas";
	}
	
	@PostMapping("editarReceita")
	public String update(@ModelAttribute("receita") Receita receita, RedirectAttributes redirAttrs) {
		receitaService.update(receita, receita.getId());
		redirAttrs.addFlashAttribute("sucessoEdicao", "Receita atualizada com sucesso!");
		
		return "redirect:/receitas";
	}
	
	@PostMapping("excluirReceita")
	public String delete(@ModelAttribute("receita") Receita receita, RedirectAttributes redirAttrs) {
		receitaService.deleteById(receita.getId());
		redirAttrs.addFlashAttribute("sucessoExclusao", "Receita excluída com sucesso!");
				
		return "redirect:/receitas";
	}
}
