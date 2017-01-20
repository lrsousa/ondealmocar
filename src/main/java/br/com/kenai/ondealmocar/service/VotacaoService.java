package br.com.kenai.ondealmocar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kenai.ondealmocar.model.Votacao;
import br.com.kenai.ondealmocar.repository.VotacaoRepository;

@Service
public class VotacaoService {
	@Autowired
	private VotacaoRepository votacaoRepository;
	
	public Votacao votacaoAtual() {
		List<Votacao> votacoes = votacaoRepository.findTop1ByOrderByIdDesc();
		if(votacoes.size() > 0) {
			return votacoes.get(0);
		}
		return null;
	}
}
