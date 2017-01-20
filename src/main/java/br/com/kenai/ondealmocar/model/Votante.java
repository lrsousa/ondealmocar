package br.com.kenai.ondealmocar.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="votante")
public class Votante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	@Column(unique=true)
	private String email;

	@OneToMany(mappedBy = "votante", cascade = CascadeType.ALL)
	List<Voto> votos;
	
	public Votante() {}
	
	public Votante(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	public Votante(long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
