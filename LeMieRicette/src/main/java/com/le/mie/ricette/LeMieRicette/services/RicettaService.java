package com.le.mie.ricette.LeMieRicette.services;

import java.util.List;

import com.le.mie.ricette.LeMieRicette.entities.Ricetta;

public interface RicettaService {

	List<Ricetta> getAllRicetta();
	List<Ricetta> getAllRicettaPerUser(String userId);
	Ricetta saveRicetta(Ricetta ricetta);
	List<Ricetta> getRicettaBase();
}
