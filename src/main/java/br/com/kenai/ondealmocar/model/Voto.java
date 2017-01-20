package br.com.kenai.ondealmocar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="voto")
public class Voto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_votacao")
	private Votacao votacao;
	
	@ManyToOne
	@JoinColumn(name = "id_votante")
	private Votante votante;
	
	@ManyToOne
	@JoinColumn(name = "id_restaurante")
	private Restaurante restaurante;
	
	public Voto() {}

	public Voto(Votacao votacao, Votante votante, Restaurante restaurante) {
		super();
		this.votacao = votacao;
		this.votante = votante;
		this.restaurante = restaurante;
	}

	public Votacao getVotacao() {
		return votacao;
	}
	public Votante getVotante() {
		return votante;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
}
