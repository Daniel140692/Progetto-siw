package it.uniroma3.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Allievo;
import it.uniroma3.repository.AllievoRepository;

@Transactional
@Service
public class AllievoService {
	
	@Autowired
	private AllievoRepository allievoRepository;
	
	public Allievo save(Allievo allievo) {
		return this.allievoRepository.save(allievo);
	}
	
	public List<Allievo> findByNome(String nome){
		return this.allievoRepository.findByNome(nome);
	}
	
	public List<Allievo> findAll(){
		return (List<Allievo>)this.allievoRepository.findAll();
	}
	
	public Allievo findById(Long id) {
		Optional<Allievo> allievo =this.allievoRepository.findById(id);
		
		if(allievo.isPresent())
			return allievo.get();
		else
			return null;
	}
	
	public boolean alreadyExists(Allievo allievo) {
		List<Allievo> allievi =this.allievoRepository.findByNomeAndCognomeAndEmail(allievo.getNome(), allievo.getCognome(), allievo.getEmail());
		
		if(allievi.size() >0)
			return true;
		else 
			return false;
	}

}
