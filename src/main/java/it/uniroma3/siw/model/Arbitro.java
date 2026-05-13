package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Arbitro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@NotBlank
	@Column(nullable = false)
	private String cognome;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private Long codiceArbitrale;
	
	private String immagineUrl;
	
	// Costruttori //
	
	public Arbitro() {}
	
	public Arbitro(String nome, String cognome, Long codiceArbitrale, String immagineUrl) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceArbitrale = codiceArbitrale;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Long getCodiceArbitrale() {
		return codiceArbitrale;
	}

	public void setCodiceArbitrale(Long codiceArbitrale) {
		this.codiceArbitrale = codiceArbitrale;
	}

	public String getImmagineUrl() {
		return immagineUrl;
	}

	public void setImmagineUrl(String immagineUrl) {
		this.immagineUrl = immagineUrl;
	}

	// HashCode And Equals //
	
	@Override
	public int hashCode() {
		return Objects.hash(codiceArbitrale, cognome, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbitro other = (Arbitro) obj;
		return Objects.equals(codiceArbitrale, other.codiceArbitrale) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(nome, other.nome);
	}
	
	
	
	

}
