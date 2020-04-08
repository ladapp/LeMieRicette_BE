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
@Table(name="ricette_ingredienti")
public class RicetteIngredients {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="id_ricetta")
	@NotEmpty @NotBlank @NotNull
	private int id_ricetta;
	
	@Column(name="id_ingrediente")
	@NotEmpty @NotBlank @NotNull
	private int id_ingrediente;

	public RicetteIngredients(int id, @NotEmpty @NotBlank @NotNull int id_ricetta,
			@NotEmpty @NotBlank @NotNull int id_ingrediente) {
		this.id = id;
		this.id_ricetta = id_ricetta;
		this.id_ingrediente = id_ingrediente;
	}

	public RicetteIngredients(@NotEmpty @NotBlank @NotNull int id_ricetta,
			@NotEmpty @NotBlank @NotNull int id_ingrediente) {
		this.id_ricetta = id_ricetta;
		this.id_ingrediente = id_ingrediente;
	}

	public RicetteIngredients() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ricetta() {
		return id_ricetta;
	}

	public void setId_ricetta(int id_ricetta) {
		this.id_ricetta = id_ricetta;
	}

	public int getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(int id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}
	
}
