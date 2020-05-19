package com.le.mie.ricette.LeMieRicette.entities;

import java.util.List;

public class RicettaCompleta {
	
	private Ricetta ricetta;
	private List<Step> step;
	private List<Ingrediente> ingrediente;
	
	public RicettaCompleta() {
	}
	
	public RicettaCompleta(Ricetta ricetta, List<Step> step, List<Ingrediente>ingrediente) {
		this.ricetta = ricetta;
		this.step = step;
		this.ingrediente=ingrediente;
	}
	
	public RicettaCompleta(Ricetta ricetta, List<Step> step) {
		this.ricetta = ricetta;
		this.step = step;
	}
	
	public Ricetta getRicetta() {
		return ricetta;
	}
	public void setRicetta(Ricetta ricetta) {
		this.ricetta = ricetta;
	}
	public List<Step> getStep() {
		return step;
	}
	public void setStep(List<Step> step) {
		this.step = step;
	}
	public List<Ingrediente> getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(List<Ingrediente> ingrediente) {
		this.ingrediente = ingrediente;
	}

}
