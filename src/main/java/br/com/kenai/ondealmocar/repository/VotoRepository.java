package br.com.kenai.ondealmocar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.kenai.ondealmocar.model.Votacao;
import br.com.kenai.ondealmocar.model.Votante;
import br.com.kenai.ondealmocar.model.Voto;

public interface VotoRepository extends CrudRepository<Voto, Long> {
	
	public List<Voto> findByVotacao(Votacao votacao);
	
	public List<Voto> findByVotacaoAndVotante(Votacao votacao, Votante votante);
			
}
