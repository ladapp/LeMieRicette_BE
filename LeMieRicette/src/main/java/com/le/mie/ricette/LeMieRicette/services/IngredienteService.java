package com.le.mie.ricette.LeMieRicette.services;

import java.util.List;

import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;
import com.le.mie.ricette.LeMieRicette.entities.UserIngredients;

public interface IngredienteService {

	List<Ingrediente> getAllIngrediente();
	List<UserIngredients> getAllIngredientPerUser(String id);
	void deleteIngredientUser(String userId, String ingredientId);
}
