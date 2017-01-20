package br.com.kenai.ondealmocar.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="votacao")
public class Votacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private LocalDate data;
	
	@OneToMany(mappedBy = "votacao", cascade = CascadeType.ALL)
	List<Voto> votos;
	
	public Votacao() {}
	
	public Votacao(LocalDate data) {
		super();
		this.data = data;
	}
	
	public Votacao(long id, LocalDate data) {
		super();
		this.id = id;
		this.data = data;
	}

	public LocalDate getData() {
		return data;
	}
	
	
}
