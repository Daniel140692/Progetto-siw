package it.uniroma3.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Allievo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private String email;
	
	@Column
	private String numTelefono;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascita;
	
	@Column
	private String indirizzo;
	
	@ManyToMany
	private List<Attivita> attivitaAllievo;
	
	public Allievo() {}
	
	public Allievo(String nome, String cognome, String email, String numTelefono, String indirizzo, Date dataNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.numTelefono = numTelefono;
		this.dataNascita = dataNascita;
		this.indirizzo = indirizzo;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public List<Attivita> getAttivita() {
		return attivitaAllievo;
	}

	public void setAttivita(List<Attivita> attivita) {
		this.attivitaAllievo = attivita;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
}
