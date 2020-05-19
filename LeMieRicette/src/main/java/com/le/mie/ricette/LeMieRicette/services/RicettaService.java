package com.le.mie.ricette.LeMieRicette.services;

import java.util.ArrayList;
import java.util.List;

import com.le.mie.ricette.LeMieRicette.entities.Ricetta;

public interface RicettaService {

	List<Ricetta> getAllRicetta();
	List<Ricetta> getAllRicettaPerUser(String userId);
	Ricetta saveRicetta(Ricetta ricetta);
	List<Ricetta> getRicettaBase();
	int getNumberOfRicette();
	List<Integer> getIDfromIngredients(ArrayList<Object> list);
	ArrayList<Ricetta> getRicetteByIngredients(List<Object> list);
	Ricetta getRicettaById(int ricettaId);
	List<Ricetta> getRicettePerPortata(String userId, String ricettaPortata);
	List<Ricetta> getRicetteBasePerPortata(String ricettaPortata);
	void deleteRicetta(int ricettaId);
}
