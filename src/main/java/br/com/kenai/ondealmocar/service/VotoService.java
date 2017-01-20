package br.com.kenai.ondealmocar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kenai.ondealmocar.model.Votacao;
import br.com.kenai.ondealmocar.model.Votante;
import br.com.kenai.ondealmocar.model.Voto;
import br.com.kenai.ondealmocar.repository.VotoRepository;

@Service
public class VotoService {
	
	@Autowired
	private VotoRepository votoRepository;
	
	public boolean jaVotou(Votacao votacao, Votante votante) {
		List<Voto> votos = votoRepository.findByVotacaoAndVotante(votacao, votante);
		if(votos.size() > 0) return true;
		return false;
	}
}
