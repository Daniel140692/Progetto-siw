package it.uniroma3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import it.uniroma3.model.Attivita;
import it.uniroma3.controller.validator.AllievoValidator;
import it.uniroma3.model.Allievo;
import it.uniroma3.service.AllievoService;
import it.uniroma3.service.AttivitaService;

@Controller
public class AllievoController implements WebMvcConfigurer {
	@Autowired
	private AttivitaService attivitaservice;
	
	@Autowired
	private AllievoService allievoService;

	@Autowired
	private AllievoValidator validator;

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }


	@RequestMapping("/attivita")
	public String attivita(Model model) {
		model.addAttribute("attivita", this.attivitaservice.findAll());
		return "attivitalist";
	}

	@RequestMapping("/addAttivita")
	public String addAttivita(Model model) {
		model.addAttribute("attivita", new Attivita());
		return "attivitaform";
	}

	@RequestMapping(value = "/attivita/{id}", method = RequestMethod.GET)
	public String getAttivita(@PathVariable("id") Long id, Model model) {
		model.addAttribute("attivita", this.attivitaservice.findById(id));
		return "showAttivita";
	}

	@PostMapping("/attivita")
    public String checkPersonInfo(@Valid Attivita attivitaform, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "attivitaform";
        }

        return "redirect:/results";
    }



	@RequestMapping("/allievi")
	public String allievi(Model model) {
		model.addAttribute("allievi", this.allievoService.findAll());
		return "allieviList";
	}

	@RequestMapping("/addAllievo")
	public String addAllievo(Model model) {
		model.addAttribute("allievo", new Allievo());
		return "allievoForm";
	}

	@RequestMapping(value = "/allievo/{id}", method = RequestMethod.GET)
	public String getAllievo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("allievo", this.allievoService.findById(id));
		return "showAllievo";
	}

	@RequestMapping(value = "/allievo" , method = RequestMethod.POST )
	public String newAllievo(@Valid @ModelAttribute ("allievo") Allievo allievo, Model model, BindingResult result) {

		this.validator.validate(allievo, result);

		if(this.allievoService.alreadyExists(allievo)) {
			model.addAttribute("exists", "L'allievo gia' è presente nel database");
			return "allievoForm";
		}
		else {
			if(!result.hasErrors()) {
				this.allievoService.save(allievo);
				model.addAttribute("allievi", this.allievoService.findAll());
				return "allieviList";
			}
		}

		return "allievoForm";
	}



}
