package it.uniroma3.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Responsabile;
import it.uniroma3.repository.ResponsabileRepository;


@Transactional
@Service
public class ResponsabileService {
	
	@Autowired
	private ResponsabileRepository responsabileRepository;
	
	public Responsabile save(Responsabile responsabile) {
		return this.responsabileRepository.save(responsabile);
	}
	
	public List<Responsabile> findByNome(String nome){
		return this.responsabileRepository.findByNome(nome);
	}
	
	public List<Responsabile> findAll(){
		return (List<Responsabile>)this.responsabileRepository.findAll();
	}
	
	public Responsabile findById(Long id) {
		Optional<Responsabile> responsabile =this.responsabileRepository.findById(id);
		
		if(responsabile.isPresent())
			return responsabile.get();
		else
			return null;
	}
	
	public boolean alreadyExists(Responsabile responsabile) {
		List<Responsabile> responsabili =this.responsabileRepository.findByNomeAndCognomeAndEmail(responsabile.getNome(), responsabile.getCognome(), responsabile.getEmail());
		
		if(responsabili.size() >0)
			return true;
		else 
			return false;
	}

}
