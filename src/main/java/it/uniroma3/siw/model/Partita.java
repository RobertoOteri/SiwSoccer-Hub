package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Partita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Stato stato;
	private LocalDateTime dataOra;
	private String luogo;
	private Integer golCasa;
	private Integer golOspiti;
	
	@ManyToOne
	private Squadra squadraInCasa;
	
	@ManyToOne
	private Squadra squadraOspite;
	
	@ManyToOne
	private Torneo torneo;
	
	// Costruttori //
	
	public Partita() {}
	
	public Partita(Stato stato, LocalDateTime dataOra, String luogo, Integer golCasa, Integer golOspiti) {
		this.stato = stato;
		this.dataOra = dataOra;
		this.luogo = luogo;
		this.golCasa = golCasa;
		this.golOspiti = golOspiti;
	}

	// Getters And Setters //
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public LocalDateTime getDataOra() {
		return dataOra;
	}

	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public Integer getGolCasa() {
		return golCasa;
	}

	public void setGolCasa(Integer golCasa) {
		this.golCasa = golCasa;
	}

	public Integer getGolOspiti() {
		return golOspiti;
	}

	public void setGolOspiti(Integer golOspiti) {
		this.golOspiti = golOspiti;
	}

	public Squadra getSquadraInCasa() {
		return squadraInCasa;
	}

	public void setSquadraInCasa(Squadra squadraInCasa) {
		this.squadraInCasa = squadraInCasa;
	}

	public Squadra getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(Squadra squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	// HashCode And Equals //
	
	@Override
	public int hashCode() {
		return Objects.hash(dataOra, luogo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partita other = (Partita) obj;
		return Objects.equals(dataOra, other.dataOra) && Objects.equals(luogo, other.luogo);
	}
	
}
