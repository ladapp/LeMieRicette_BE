package com.le.mie.ricette.LeMieRicette.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@NotNull
	private int ID;
	
	@Column(name="NOME_RICETTA")
	@NotEmpty @NotBlank @NotNull
	private String nomeRicetta;
	
	@Column(name="FK_ACCOUNT")
	private String fkaccount;
	
	@Column(name="PORTATA")
	@NotEmpty @NotBlank @NotNull
	private String portata;
	
	@Column(name="IMG")
	private String img;
	
	@Column(name="persone")
	@NotNull
	private int persone;
	
	public Ricetta() {
		
	}

	public Ricetta(@NotEmpty @NotBlank @NotNull String nomeRicetta,
			@NotEmpty @NotBlank @NotNull String portata, @NotEmpty @NotBlank @NotNull String img, @NotEmpty @NotBlank @NotNull int persone) {
		this.nomeRicetta = nomeRicetta;
		this.portata = portata;
		this.img = img;
		this.persone = persone;
	}
	
	public Ricetta(@NotEmpty @NotBlank @NotNull String nomeRicetta, 
			String fkaccount, @NotEmpty @NotBlank @NotNull String portata, @NotEmpty @NotBlank @NotNull String img, @NotEmpty @NotBlank @NotNull int persone) {
		this.nomeRicetta = nomeRicetta;
		this.fkaccount = fkaccount;
		this.portata = portata;
		this.img = img;
		this.persone = persone;
	}

	public Ricetta(@NotEmpty @NotBlank @NotNull int id, @NotEmpty @NotBlank @NotNull String nomeRicetta, String fkaccount,
			@NotEmpty @NotBlank @NotNull String portata, @NotEmpty @NotBlank @NotNull String img, @NotEmpty @NotBlank @NotNull int persone) {
		this.ID = id;
		this.nomeRicetta = nomeRicetta;
		this.fkaccount = fkaccount;
		this.portata = portata;
		this.img = img;
		this.persone = persone;
	}

	public Ricetta(@NotEmpty @NotBlank @NotNull int id, @NotEmpty @NotBlank @NotNull String nomeRicetta, @NotEmpty @NotBlank @NotNull String portata,
			@NotEmpty @NotBlank @NotNull String img, @NotEmpty @NotBlank @NotNull int persone) {
		this.ID = id;
		this.nomeRicetta = nomeRicetta;
		this.portata = portata;
		this.img = img;
		this.persone = persone;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
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

	public int getPersone() {
		return persone;
	}

	public void setPersone(int persone) {
		this.persone = persone;
	}
	
}
