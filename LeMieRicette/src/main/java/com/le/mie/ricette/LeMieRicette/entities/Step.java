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
@Table(name="steps")
public class Step {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="id_ricetta")
	@NotNull
	private int idRicetta;
	
	@Column(name="num_step")
	@NotNull
	private int numStep;
	
	@Column(name="descrizione")
	@NotEmpty @NotBlank @NotNull
	private String descrizione;

	public Step(int id, @NotEmpty @NotBlank @NotNull int idRicetta, @NotEmpty @NotBlank @NotNull int numStep,
			@NotEmpty @NotBlank @NotNull String descrizione) {
		this.id = id;
		this.idRicetta = idRicetta;
		this.numStep = numStep;
		this.descrizione = descrizione;
	}

	public Step(@NotEmpty @NotBlank @NotNull int idRicetta, @NotEmpty @NotBlank @NotNull int numStep,
			@NotEmpty @NotBlank @NotNull String descrizione) {
		this.idRicetta = idRicetta;
		this.numStep = numStep;
		this.descrizione = descrizione;
	}

	public Step() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRicetta() {
		return idRicetta;
	}

	public void setIdRicetta(int idRicetta) {
		this.idRicetta = idRicetta;
	}

	public int getNumStep() {
		return numStep;
	}

	public void setNumStep(int numStep) {
		this.numStep = numStep;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
