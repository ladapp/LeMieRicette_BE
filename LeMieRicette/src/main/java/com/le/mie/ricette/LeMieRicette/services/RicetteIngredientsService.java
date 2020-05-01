package com.le.mie.ricette.LeMieRicette.services;
import java.util.List;
import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;

public interface RicetteIngredientsService {

	void addRicettaIngredients(int id_ricetta, int id_ingrediente);
	List <Ingrediente> findIngredientsByRicettaId(int ricettaId);
	
}
