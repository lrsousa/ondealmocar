package br.com.kenai.ondealmocar.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="restaurante")
public class Restaurante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;

	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
	List<Voto> votos;
	
	public Restaurante() {}
	
	public Restaurante(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public long getId() {
		return id;
	}
	
	
}
