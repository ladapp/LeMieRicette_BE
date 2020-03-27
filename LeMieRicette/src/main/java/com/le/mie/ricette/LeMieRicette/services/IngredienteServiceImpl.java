package com.le.mie.ricette.LeMieRicette.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.le.mie.ricette.LeMieRicette.daos.IngredienteDao;
import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;

@Service
public class IngredienteServiceImpl implements IngredienteService{
	
	@Autowired
	IngredienteDao ingredienteDao;

	@Override
	public List<Ingrediente> getAllIngrediente() {
		return ingredienteDao.findAll();
	}

}
