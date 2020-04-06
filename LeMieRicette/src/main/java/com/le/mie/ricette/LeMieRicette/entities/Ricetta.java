package com.le.mie.ricette.LeMieRicette.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ricette")
public class Ricetta {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOME_RICETTA")
	@NotEmpty @NotBlank @NotNull
	private String nomeRicetta;
	
	@Column(name="FK_ACCOUNT")
	private String fkaccount;
	
	@Column(name="PORTATA")
	@NotEmpty @NotBlank @NotNull
	private String portata;
	
	@Column(name="IMG")
	@NotEmpty @NotBlank @NotNull
	private String img;
	
	public Ricetta() {
		
	}

	public Ricetta(@NotEmpty @NotBlank @NotNull String nomeRicetta,
			@NotEmpty @NotBlank @NotNull String portata, @NotEmpty @NotBlank @NotNull String img) {
		this.nomeRicetta = nomeRicetta;
		this.portata = portata;
		this.img = img;
	}
	
	public Ricetta(@NotEmpty @NotBlank @NotNull String nomeRicetta, 
			String fkaccount, @NotEmpty @NotBlank @NotNull String portata, @NotEmpty @NotBlank @NotNull String img) {
		this.nomeRicetta = nomeRicetta;
		this.fkaccount = fkaccount;
		this.portata = portata;
		this.img = img;
	}

	public Ricetta(int id, @NotEmpty @NotBlank @NotNull String nomeRicetta, String fkaccount,
			@NotEmpty @NotBlank @NotNull String portata, @NotEmpty @NotBlank @NotNull String img) {
		this.id = id;
		this.nomeRicetta = nomeRicetta;
		this.fkaccount = fkaccount;
		this.portata = portata;
		this.img = img;
	}

	public Ricetta(int id, @NotEmpty @NotBlank @NotNull String nomeRicetta, @NotEmpty @NotBlank @NotNull String portata,
			@NotEmpty @NotBlank @NotNull String img) {
		this.id = id;
		this.nomeRicetta = nomeRicetta;
		this.portata = portata;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRicetta() {
		return nomeRicetta;
	}

	public void setNomeRicetta(String nomeRicetta) {
		this.nomeRicetta = nomeRicetta;
	}

	public String getFkaccount() {
		return fkaccount;
	}

	public void setFkaccount(String fkaccount) {
		this.fkaccount = fkaccount;
	}

	public String getPortata() {
		return portata;
	}

	public void setPortata(String portata) {
		this.portata = portata;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
