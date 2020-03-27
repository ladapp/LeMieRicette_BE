package com.le.mie.ricette.LeMieRicette.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.le.mie.ricette.LeMieRicette.daos.RicettaDao;
import com.le.mie.ricette.LeMieRicette.entities.Ricetta;

@Service
public class RicettaServiceImpl implements RicettaService{
	
	@Autowired
	RicettaDao ricettaDao;

	@Override
	public List<Ricetta> getAllRicetta() {
		
		return ricettaDao.findAll();
	}

	@Override
	public List<Ricetta> getAllRicettaPerUser(String userId) {
		return ricettaDao.findAllRicetteByAccount(userId);
	}

	@Override
	public Ricetta saveRicetta(Ricetta ricetta) {
		return ricettaDao.save(ricetta);
	}

	@Override
	public List<Ricetta> getRicettaBase() {
		return ricettaDao.findAllRicettaBase();
	}

}
