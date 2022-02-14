package br.com.zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.zero.model.Ingrediente;
import br.com.zero.service.IngredienteService;

@Controller
@RequestMapping("/")
public class IngredienteController {

	@Autowired
	IngredienteService ingredienteService;
	
	@GetMapping("ingredientes")
	public String ingrediente(Model model) {
		return "ingredientes";
	}
	
	@PostMapping("cadastrarIngrediente")
	public String create(@ModelAttribute("ingrediente") Ingrediente ingrediente, RedirectAttributes redirAttrs) {
		Ingrediente i = new Ingrediente(ingrediente.getNome(), ingrediente.getQuantidade());
		ingredienteService.create(i);
		redirAttrs.addFlashAttribute("sucessoCadastro", "Ingrediente cadastrado com sucesso!");
		
		return "redirect:/ingredientes";
	}
	
	@PostMapping("editarIngrediente")
	public String update(@ModelAttribute("ingrediente") Ingrediente ingrediente, RedirectAttributes redirAttrs) {
		ingredienteService.update(ingrediente, ingrediente.getId());
		redirAttrs.addFlashAttribute("sucessoEdicao", "Ingrediente atualizado com sucesso!");	
		
		return "redirect:/ingredientes";
	}
	
	@PostMapping("excluirIngrediente")
	public String delete(@ModelAttribute("ingrediente") Ingrediente ingrediente, RedirectAttributes redirAttrs) {
		ingredienteService.deleteByIngrediente(ingrediente);
		redirAttrs.addFlashAttribute("sucessoExclusao", "Ingrediente excluído com sucesso!");	
		
		return "redirect:/ingredientes";
	}
}
