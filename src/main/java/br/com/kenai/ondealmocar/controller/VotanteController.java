package br.com.kenai.ondealmocar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.kenai.ondealmocar.model.Votante;
import br.com.kenai.ondealmocar.repository.VotanteRepository;

@Controller
@EnableWebMvc
public class VotanteController {
	
	@Autowired
	private VotanteRepository votanteRepository;
	
	@RequestMapping("/novoVotante")
	public String novoVotante() {
		return "novo-votante";
	}
	
	@RequestMapping("/salvarNovoVotante")
	public String salvar(Votante votante) {
		votanteRepository.save(votante);
		return "redirect:/";
	}
}
