package br.com.kenai.ondealmocar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.kenai.ondealmocar.model.Votante;

public interface VotanteRepository extends CrudRepository<Votante, Long> {
	
	public Votante findByEmail(String email);
	
}
