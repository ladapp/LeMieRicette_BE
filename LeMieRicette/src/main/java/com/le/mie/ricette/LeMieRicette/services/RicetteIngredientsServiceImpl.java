package com.le.mie.ricette.LeMieRicette.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.le.mie.ricette.LeMieRicette.daos.RicetteIngredientsDao;
import com.le.mie.ricette.LeMieRicette.entities.RicetteIngredients;

@Service
public class RicetteIngredientsServiceImpl implements RicetteIngredientsService{

	@Autowired
	RicetteIngredientsDao ricetteIngredientsDao;
	
	@Override
	public void addRicettaIngredients(int id_ricetta, int id_ingrediente) {
		ricetteIngredientsDao.save(new RicetteIngredients(id_ricetta, id_ingrediente));
	}

}
