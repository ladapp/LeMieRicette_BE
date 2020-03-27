package com.le.mie.ricette.LeMieRicette.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users_ingredients")
public class UserIngredients {

	@Column(name = "user_id")
	@NotEmpty @NotBlank @NotNull
	private String user_id;
	
	@Column(name = "ingredients_id")
	@NotEmpty @NotBlank @NotNull
	private String ingredients_id;

	public UserIngredients(@NotEmpty @NotBlank @NotNull String user_id,
			@NotEmpty @NotBlank @NotNull String ingredients_id) {
		this.user_id = user_id;
		this.ingredients_id = ingredients_id;
	}
	
	public UserIngredients() {
		
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getIngredients_id() {
		return ingredients_id;
	}

	public void setIngredients_id(String ingredients_id) {
		this.ingredients_id = ingredients_id;
	}
}
