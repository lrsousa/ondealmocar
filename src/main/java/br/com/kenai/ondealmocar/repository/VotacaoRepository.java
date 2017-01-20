package br.com.kenai.ondealmocar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.kenai.ondealmocar.model.Votacao;

public interface VotacaoRepository extends CrudRepository<Votacao, Long> {
	
	List<Votacao> findTop1ByOrderByIdDesc();
	
}
