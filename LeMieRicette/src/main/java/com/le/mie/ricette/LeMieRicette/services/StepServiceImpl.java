package com.le.mie.ricette.LeMieRicette.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.le.mie.ricette.LeMieRicette.daos.StepDao;
import com.le.mie.ricette.LeMieRicette.entities.Step;

@Service
public class StepServiceImpl implements StepService{

	@Autowired
	StepDao stepDao;
	
	@Override
	public List<Step> findAllByRicettaId(int ricettaId) {
		return stepDao.getAllStepByRicettaId(ricettaId);
	}

	@Override
	public void addRicettaStep(int idRicetta, int numStep, String descrizione) {
		stepDao.save(new Step(idRicetta, numStep, descrizione));
		
	}
	
	@Override
	public List<Step> findAllStepsByRicettaIdCompl(int ricettaId) {
		return stepDao.getAllStepsByRicettaIdCompl(ricettaId);
	}

}
