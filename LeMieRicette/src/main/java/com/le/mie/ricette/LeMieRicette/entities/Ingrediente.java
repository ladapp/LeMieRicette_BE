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

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="ingredienti")
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private String id;
	
	@Column(name="NOME_INGREDIENTE")
	@NotEmpty @NotBlank @NotNull
	private String nomeIngrediente;

	public Ingrediente(String id, @NotEmpty @NotBlank @NotNull String nomeIngrediente) {
		this.id = id;
		this.nomeIngrediente = nomeIngrediente;
	}
	
	public Ingrediente(@NotEmpty @NotBlank @NotNull String nomeIngrediente) {
		this.nomeIngrediente = nomeIngrediente;
	}
	
	public Ingrediente() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeIngrediente() {
		return nomeIngrediente;
	}

	public void setNomeIngrediente(String nomeIngrediente) {
		this.nomeIngrediente = nomeIngrediente;
	}
	
}
