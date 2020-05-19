package com.le.mie.ricette.LeMieRicette.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.le.mie.ricette.LeMieRicette.daos.IngredientiRicettaDAO;
import com.le.mie.ricette.LeMieRicette.daos.RicetteIngredientsDao;
import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;
import com.le.mie.ricette.LeMieRicette.entities.RicetteIngredients;

@Service
public class RicetteIngredientsServiceImpl implements RicetteIngredientsService{

	@Autowired
	RicetteIngredientsDao ricetteIngredientsDao;
	
	@Autowired
	IngredientiRicettaDAO ingredientiRicettaDAO;
	
	
	@Override
	public void addRicettaIngredients(int id_ricetta, int id_ingrediente) {
		ricetteIngredientsDao.save(new RicetteIngredients(id_ricetta, id_ingrediente));
	}
	
	@Override
	public List<Ingrediente> findIngredientsByRicettaId(int ricettaId) {
		return ingredientiRicettaDAO.getIngredientsByRicettaId(ricettaId);
	}

}
