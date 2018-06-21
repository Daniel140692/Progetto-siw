package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo, Long> {

	public List<Allievo> findByNome (String nome);
	
	public List<Allievo> findByNomeAndCognomeAndEmail(String nome, String cognome, String email);
		
}
