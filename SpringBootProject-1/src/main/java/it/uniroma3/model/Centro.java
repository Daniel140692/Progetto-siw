package it.uniroma3.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Centro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable= false)
	private String nome;

	@Column(nullable= false)
	private String email;

	@Column
	private String telefono;

	@Column(nullable= false)
	private int capienza;

	@OneToMany
	private List<Attivita> listaAttivita;

	public Centro(){}

	public Centro(String nome, String email, int capienza) {
		this.nome = nome;
		this.email = email;
		this.capienza = capienza;
	}



	public List<Attivita> getListaAttivita() {
		return listaAttivita;
	}



	public void setListaAttivita(List<Attivita> listaAttivita) {
		this.listaAttivita = listaAttivita;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}


}
