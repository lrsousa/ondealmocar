package br.com.kenai.ondealmocar.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.kenai.ondealmocar.model.Restaurante;
import br.com.kenai.ondealmocar.model.Votacao;
import br.com.kenai.ondealmocar.model.Voto;
import br.com.kenai.ondealmocar.repository.RestauranteRepository;
import br.com.kenai.ondealmocar.repository.VotacaoRepository;
import br.com.kenai.ondealmocar.repository.VotoRepository;
import br.com.kenai.ondealmocar.service.VotacaoService;

@Controller
@EnableWebMvc
public class VotacaoController {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private VotacaoService votacaoService;
	
	@Autowired
	private VotacaoRepository votacaoRepository;
	
	@Autowired
	private VotoRepository votoRepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		
		Votacao votacaoAtual = votacaoService.votacaoAtual();

		if(!votacaoAtual.getData().equals(LocalDate.now())) {
			votacaoAtual = criarVotacao();
		}
		
		Iterable<Restaurante> restaurantes = restauranteRepository.findAllByOrderByNome();
		model.addAttribute("restaurantes", restaurantes);
		return "index";
	}
	
	@RequestMapping(name="resultadoParcial", method=RequestMethod.GET, produces="application/json", headers="Accept=application/json")
	@ResponseBody
	public String resultadoParcial() {
		Votacao votacaoAtual = votacaoService.votacaoAtual();
		List<Voto> votos = votoRepository.findByVotacao(votacaoAtual);
		String array = criarArrayDeVotos(votos);
		return array;
	}
	
	private String criarArrayDeVotos(List<Voto> votos) {
		JSONArray jsonArray = new JSONArray();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		if(votos.isEmpty()) {
			map.put("Vazio", 1);
			jsonArray.put(map);
			return jsonArray.toString().replace("{", "[")
									.replace("}", "]")
									.replace(",", "],[")
									.replace(":", ",");
		}
		
		for (Voto voto : votos) {
			if(map.containsKey(voto.getRestaurante().getNome())) {
				map.merge(voto.getRestaurante().getNome(), 1, Integer::sum);
			} else {
				map.put(voto.getRestaurante().getNome(), 1);
			}
		}
		jsonArray.put(map);
		
		return jsonArray.toString().replace("{", "[")
									.replace("}", "]")
									.replace(",", "],[")
									.replace(":", ",");
	}
	
	private Votacao criarVotacao() {
		return votacaoRepository.save(new Votacao(LocalDate.now()));
	}
}
