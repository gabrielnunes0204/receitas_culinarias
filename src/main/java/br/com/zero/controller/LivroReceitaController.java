package br.com.zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.zero.model.LivroReceita;
import br.com.zero.service.LivroReceitaService;

@Controller
@RequestMapping("/")
public class LivroReceitaController {

	@Autowired
	LivroReceitaService livroService;
	
	@GetMapping("livroReceitas")
	public String livro(Model model) {
		return "livroReceitas";
	}
	
	@PostMapping("cadastrarLivro")
	public String create(@ModelAttribute("livroreceita") LivroReceita livro, RedirectAttributes redirAttrs) {
		LivroReceita l = new LivroReceita(livro.getNome(), livro.getCategoria());
		
		livroService.create(l);
		redirAttrs.addFlashAttribute("sucessoCadastro", "Livro cadastrado com sucesso!");
		return "redirect:/livroReceitas";
	}
	
	@PostMapping("editarLivro")
	public String update(@ModelAttribute("livroreceita") LivroReceita livro, RedirectAttributes redirAttrs) {
		livroService.update(livro, livro.getId());
		
		redirAttrs.addFlashAttribute("sucessoEdicao", "Livro atualizado com sucesso!");
		return "redirect:/livroReceitas";
	}
	
	@PostMapping("excluirLivro")
	public String delete(@ModelAttribute("livroreceita") LivroReceita livro, RedirectAttributes redirAttrs) {
		livroService.deleteByLivro(livro);
		
		redirAttrs.addFlashAttribute("sucessoExclusao", "Livro excluído com sucesso!");
		return "redirect:/livroReceitas";
	}
}
