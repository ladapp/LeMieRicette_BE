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
	@NotEmpty @NotBlank @NotNull
	private String id;
	
	@Column(name="NOME_RICETTA")
	@NotEmpty @NotBlank @NotNull
	private String nomeRicetta;
	
	@Column(name="FK_ACCOUNT")
	private String fkaccount;
	
	public Ricetta() {
		
	}

	public Ricetta(@NotEmpty @NotBlank @NotNull String id, @NotEmpty @NotBlank @NotNull String nomeRicetta) {
		this.id = id;
		this.nomeRicetta = nomeRicetta;
	}
	
	public Ricetta(@NotEmpty @NotBlank @NotNull String id, @NotEmpty @NotBlank @NotNull String nomeRicetta, 
			String fkaccount) {
		this.id = id;
		this.nomeRicetta = nomeRicetta;
		this.fkaccount = fkaccount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
}