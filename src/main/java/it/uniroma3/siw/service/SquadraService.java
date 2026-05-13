package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Squadra;
import it.uniroma3.siw.repository.SquadraRepository;

@Service
public class SquadraService {
	
	private SquadraRepository squadraRepository;
	
	public SquadraService(SquadraRepository squadraRepository) {
		this.squadraRepository = squadraRepository;
	}
	
	public Squadra save(Squadra squadra) {
		return this.squadraRepository.save(squadra);
	}
	
	public List<Squadra> findAll(){
		return (List<Squadra>) this.squadraRepository.findAll();
	}
	
	public Squadra findById(Long id) {
		return this.squadraRepository.findById(id).get();
	}

}
