package it.uniroma3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.uniroma3.model.Allievo;
import it.uniroma3.model.Attivita;
import it.uniroma3.model.Centro;
import it.uniroma3.service.AllievoService;
import it.uniroma3.service.AttivitaService;
import it.uniroma3.service.CentroService;

@SpringBootApplication
public class SiwDemoSpringApplication {


	@Autowired
	private AllievoService allievoService;

	@Autowired
	private CentroService centroService;

	@Autowired
	private AttivitaService attivitaService;


	public static void main(String[] args) {
		SpringApplication.run(SiwDemoSpringApplication.class, args);
	}

	@PostConstruct
	public void init() {
		Allievo allievo1 = new Allievo("Daniele","Cerriti", "cerrix_92@hotmail.it", "0774123467", "viale Roma", new Date());
		Centro centroRoma = new Centro("RomaCenter","rmc@gmail.com",100);
		Centro centroMilano = new Centro("MilanoCenter", "mlc@gmail.com", 50);

		Attivita a1 = new Attivita("Basket");
		Attivita a2 = new Attivita("Calcio");
		Attivita a3 = new Attivita("Tennis");

		List<Attivita> attivitaRoma = new ArrayList<>();
		List<Attivita> attivitaMilano = new ArrayList<>();

		attivitaRoma.add(a1);
		attivitaRoma.add(a2);
		attivitaMilano.add(a3);

		centroRoma.setListaAttivita(attivitaRoma);
		centroMilano.setListaAttivita(attivitaMilano);

		attivitaService.save(a1);
		attivitaService.save(a2);
		attivitaService.save(a3);
		allievoService.save(allievo1);
		centroService.save(centroRoma);
		centroService.save(centroMilano);

	}
		

	}

