package com.le.mie.ricette.LeMieRicette.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name = "ID")
	@NotEmpty @NotBlank @NotNull
	private String id;
	
	@Column(name="NOME")
	@NotEmpty @NotBlank @NotNull
	private String nome;
	
	@Column(name="COGNOME")
	@NotEmpty @NotBlank @NotNull
	private String cognome;
	
	@Column(name="EMAIL")
	@NotEmpty @NotBlank @NotNull
	private String email;
	
	@Column(name="PASSWORD")
	@NotEmpty @NotBlank @NotNull
	private String password;
	
	@Column(name = "PERMISSION")
	@NotEmpty @NotBlank @NotNull
	private String permission;
	
	public User() {
		
	}

	public User(@NotEmpty @NotBlank @NotNull String id, @NotEmpty @NotBlank @NotNull String nome,
			@NotEmpty @NotBlank @NotNull String cognome, @NotEmpty @NotBlank @NotNull String email,
			@NotEmpty @NotBlank @NotNull String password, @NotEmpty @NotBlank @NotNull String permission) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.permission = permission;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
