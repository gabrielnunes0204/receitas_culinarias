package br.com.zero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AreaLogadoController {
	
	@GetMapping("areaLogado")
	public String areaLogado(Model model) {		
		return "areaLogado";
	}
}
