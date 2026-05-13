package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Squadra;
import it.uniroma3.siw.model.Torneo;
import it.uniroma3.siw.repository.SquadraRepository;
import it.uniroma3.siw.service.SquadraService;
import jakarta.validation.Valid;

@Controller
public class SquadraController {
	
	private SquadraService squadraService;
	
	public SquadraController(SquadraService squadraService) {
		this.squadraService = squadraService;
	}
	
	@GetMapping("/squadre")
	public String getSquadre(Model model) {
		List<Squadra> squadre = this.squadraService.findAll();
		model.addAttribute("squadre", squadre);
		return "squadre/list";		
	}
	
	@GetMapping("/squadre/{id}")
	public String getSquadra(@PathVariable("id") Long id, Model model) {
		Squadra squadra = this.squadraService.findById(id);
		model.addAttribute("squadra", squadra);
		return "squadre/show";
		
	}
	
	
	@PostMapping("/admin/squadre")
	public String newSquadra(@Valid @ModelAttribute("squadra") Squadra squadra, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/admin/squadre/form";
		}else {
			this.squadraService.save(squadra);
			return "redirect:/squadre";
		}
	}
	
	@GetMapping("admin/squadre/form")
	public String formNuovaSquadra(Model model) {
		model.addAttribute("squadra", new Squadra());
		return "admin/squadre/form";
	}

}
