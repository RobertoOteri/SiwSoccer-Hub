package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

import it.uniroma3.siw.model.Torneo;
import it.uniroma3.siw.model.*;
import it.uniroma3.siw.service.TorneoService;
import jakarta.validation.Valid;

@Controller
public class TorneoController {
	
	private TorneoService torneoService;
	
	public TorneoController(TorneoService torneoService) {
		this.torneoService = torneoService;
	}
	
	@GetMapping("/tornei")
	public String getTornei(Model model) {
		List<Torneo> tornei = this.torneoService.findAll();
		model.addAttribute("tornei", tornei);
		return "tornei/list";
	}
	
	@GetMapping("/tornei/{id}")
	public String getTorneoById(@PathVariable("id") Long id, Model model) {
		Torneo torneo = this.torneoService.findById(id);
		model.addAttribute("torneo", torneo);
		return "tornei/show";
	}

	@GetMapping("/tornei/{id}/squadre-disponibili")
	public String getSquadreDisponibili(@PathVariable("id") Long id, Model model) {
		List<Squadra> squadreDisponibili = this.torneoService.findSquadreNonIscritteATorneo(id);
		Torneo torneo = this.torneoService.findById(id);
		model.addAttribute("torneo", torneo);
		model.addAttribute("squadreDisponibili", squadreDisponibili);
		return "tornei/squadre-disponibili";
	}
	
	@PostMapping("/tornei/{id}/iscrivi")
	public String inserisciSquadra(@PathVariable("id") Long id, @RequestParam(value = "squadreIds", required = false) List<Long> squadreIds) {
		if(squadreIds != null && !squadreIds.isEmpty()) {
			this.torneoService.iscriviSquadreAlTorneo(id, squadreIds);
		}
		return "redirect:/tornei/" +id;
	}
	
	@PostMapping("/admin/tornei")
	public String newTorneo(@Valid @ModelAttribute("torneo") Torneo torneo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/admin/tornei/form";
		}else {
			this.torneoService.save(torneo);
			return "redirect:/tornei";
		}
	}
	
	@GetMapping("admin/tornei/form")
	public String formNuovoTorneo(Model model) {
		model.addAttribute("torneo", new Torneo());
		return "admin/tornei/form";
	}
	

}
