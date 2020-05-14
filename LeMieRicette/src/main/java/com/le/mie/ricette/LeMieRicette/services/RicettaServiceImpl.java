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

	@Override
	public int getNumberOfRicette() {
		return ricettaDao.getNumberOfRicette();
	}
	
	@Override
	public Ricetta getRicettaById(int ricettaId) {
		return ricettaDao.findRicettaById(ricettaId);
	}
	
	@Override
	public List<Ricetta> getRicettePerPortata(String userId, String ricettaPortata) {
		return ricettaDao.findRicettaByPortata(userId, ricettaPortata);
	}
	
	@Override
	public List<Ricetta> getRicetteBasePerPortata (String ricettaPortata){
		return ricettaDao.findRicettaBaseByPortata(ricettaPortata);
	}
	
	@Override
	public void deleteRicetta(int ricettaId) {
		ricettaDao.deleteRicettaUser(ricettaId);
	}

}
