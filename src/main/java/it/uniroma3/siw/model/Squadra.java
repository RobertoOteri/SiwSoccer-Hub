package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Squadra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, unique = true)
	private String nome;
	
	private Integer annoDiFondazione;
	private String citta;
	private String immagineUrl;
	
	@OneToMany(mappedBy = "squadra")
	private List<Giocatore> giocatori;
	
	@ManyToMany(mappedBy = "squadre")
	private List<Torneo> tornei;
	
	// Costruttori //
	
	public Squadra() {}
	
	public Squadra(String nome,Integer annoDiFondazione, String citta, String immagineUrl) {
		this.nome = nome;
		this.annoDiFondazione = annoDiFondazione;
		this.citta = citta;
		this.immagineUrl = immagineUrl;
	}

	
	// Getters And Setters //
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAnnoDiFondazione() {
		return annoDiFondazione;
	}

	public void setAnnoDiFondazione(Integer annoDiFondazione) {
		this.annoDiFondazione = annoDiFondazione;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getImmagineUrl() {
		return immagineUrl;
	}

	public void setImmagineUrl(String immagineUrl) {
		this.immagineUrl = immagineUrl;
	}

	public List<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}
	
	public List<Torneo> getTornei() {
		return tornei;
	}

	public void setTornei(List<Torneo> tornei) {
		this.tornei = tornei;
	}
	
	// HashCode And Equals //
	

	@Override
	public int hashCode() {
		return Objects.hash(annoDiFondazione, citta, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Squadra other = (Squadra) obj;
		return Objects.equals(annoDiFondazione, other.annoDiFondazione) && Objects.equals(citta, other.citta)
				&& Objects.equals(nome, other.nome);
	}

	
}
