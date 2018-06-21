package it.uniroma3.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Centro;
import it.uniroma3.repository.CentroRepository;

@Transactional
@Service
public class CentroService {
	
	@Autowired
	private CentroRepository centroRepository;
	
	public Centro save(Centro centro) {
		return this.centroRepository.save(centro);
	}
	
	public List<Centro> findAll(){
		return (List<Centro>)this.centroRepository.findAll();
	}
	
	public Centro findById(Long id) {
		Optional<Centro> centro = this.centroRepository.findById(id);
		
		if(centro.isPresent())
			return centro.get();
		else
			return null;
	}
	
	public boolean alreadyExists(Centro centro) {
		List<Centro> centri = this.centroRepository.findByNome(centro.getNome());
		
		if(centri.size()>0)
			return true;
		else
			return false;
	}

}
