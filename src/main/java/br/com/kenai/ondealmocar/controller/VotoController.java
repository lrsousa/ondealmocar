package br.com.kenai.ondealmocar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.kenai.ondealmocar.model.Restaurante;
import br.com.kenai.ondealmocar.model.Votacao;
import br.com.kenai.ondealmocar.model.Votante;
import br.com.kenai.ondealmocar.model.Voto;
import br.com.kenai.ondealmocar.repository.VotanteRepository;
import br.com.kenai.ondealmocar.repository.VotoRepository;
import br.com.kenai.ondealmocar.service.VotacaoService;
import br.com.kenai.ondealmocar.service.VotoService;

@Controller
@EnableWebMvc
public class VotoController {

	@Autowired
	VotacaoService votacaoService;
	
	@Autowired
	VotoService votoService;
	
	@Autowired
	private VotanteRepository votanteRepository;
	
	@Autowired
	private VotoRepository votoRepository;
	
	@RequestMapping("votar")
	public String votar(@RequestParam("email") String email, @RequestParam("restaurante") Integer idRestaurante, Model model) {
		Votacao votacao = votacaoService.votacaoAtual();
		Votante votante = votanteRepository.findByEmail(email);
		Restaurante restaurante = new Restaurante(idRestaurante, null);
		
		if(votante == null) {
			return "redirect:novoVotante";
		}
		
		if(votoService.jaVotou(votacao, votante)) {
			model.addAttribute("jaVotou", true);
		} else {
			votoRepository.save(new Voto(votacao, votante, restaurante));
		}
		
		return "redirect:/";
	}
}
