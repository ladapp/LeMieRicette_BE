package com.le.mie.ricette.LeMieRicette.services;

import java.util.List;

import com.le.mie.ricette.LeMieRicette.entities.Step;

public interface StepService {

	List<Step> findAllByRicettaId(int ricettaId);
}
