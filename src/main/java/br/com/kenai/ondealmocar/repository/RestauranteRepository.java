package br.com.kenai.ondealmocar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.kenai.ondealmocar.model.Restaurante;

public interface RestauranteRepository extends CrudRepository<Restaurante, Long> {
	public List<Restaurante> findAllByOrderByNome();
}
