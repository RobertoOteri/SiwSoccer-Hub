package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Squadra;
import it.uniroma3.siw.model.Torneo;
import it.uniroma3.siw.repository.SquadraRepository;
import it.uniroma3.siw.repository.TorneoRepository;

@Service
public class TorneoService {
	
	private TorneoRepository torneoRepository;
	
	private SquadraRepository squadraRepository;
	
	public TorneoService(TorneoRepository torneoRepository, SquadraRepository squadraRepository) {
		this.torneoRepository = torneoRepository;
		this.squadraRepository = squadraRepository;
	}
	
	public Torneo save(Torneo torneo) {
		return this.torneoRepository.save(torneo);
	}
	
	public List<Torneo> findAll(){
		return (List<Torneo>) this.torneoRepository.findAll();
	}
	
	public Torneo findById(Long id) {
		return this.torneoRepository.findById(id).get();
	}
	
	public List<Squadra> findSquadreNonIscritteATorneo(Long id){
		return this.torneoRepository.findSquadreNonIscritteATorneo(id);
		
	}
	
	public void iscriviSquadreAlTorneo(Long id, List<Long> squadreIds) {
		Torneo torneo = this.torneoRepository.findById(id).get();
		List<Squadra> squadreDaIscrivere = (List<Squadra>) this.squadraRepository.findAllById(squadreIds);
		torneo.getSquadre().addAll(squadreDaIscrivere);
		this.torneoRepository.save(torneo);
	}

}

