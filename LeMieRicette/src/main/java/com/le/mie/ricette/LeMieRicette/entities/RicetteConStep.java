package com.le.mie.ricette.LeMieRicette.entities;

import java.util.List;

public class RicetteConStep {
	
	private Ricetta ricetta;
	private List<Step> step;
	
	
	public RicetteConStep() {
	}
	public RicetteConStep(Ricetta ricetta, List<Step> step) {
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

}
