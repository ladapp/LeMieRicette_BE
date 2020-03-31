package com.le.mie.ricette.LeMieRicette.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.le.mie.ricette.LeMieRicette.daos.IngredienteDao;
import com.le.mie.ricette.LeMieRicette.daos.UserIngredientsDao;
import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;
import com.le.mie.ricette.LeMieRicette.entities.UserIngredients;

@Service
public class IngredienteServiceImpl implements IngredienteService{
	
	@Autowired
	IngredienteDao ingredienteDao;
	
	@Autowired
	UserIngredientsDao userIngredientsDao;

	@Override
	public List<Ingrediente> getAllIngrediente() {
		return ingredienteDao.findAll();
	}

	@Override
	public List<UserIngredients> getAllIngredientPerUser(String id) {
		List<UserIngredients> list = new ArrayList<UserIngredients>();
		list = userIngredientsDao.findAllIngredientsByUserId(id);
		return list;
	}

	@Override
	public void deleteIngredientUser(String userId, String ingredientId) {
		// TODO Auto-generated method stub
		userIngredientsDao.deleteIngredientsUser(userId, ingredientId);
	}

}
