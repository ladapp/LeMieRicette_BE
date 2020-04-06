package com.le.mie.ricette.LeMieRicette.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.le.mie.ricette.LeMieRicette.JsonResponseBody.JsonResponseBody;
import com.le.mie.ricette.LeMieRicette.entities.Ricetta;
import com.le.mie.ricette.LeMieRicette.entities.RicetteConStep;
import com.le.mie.ricette.LeMieRicette.services.RicettaService;
import com.le.mie.ricette.LeMieRicette.services.StepService;

@RestController
public class RicetteController {

	private static final Logger log = LoggerFactory.getLogger(RicetteController.class);
	
	@Autowired
	RicettaService ricettaService;
	
	@Autowired
	StepService stepService;
	
	@RequestMapping("/ricetteBase")
	public ResponseEntity<JsonResponseBody> findAllRicetteBase() throws UnsupportedEncodingException {
		log.info("/ricetteBase");
		
		List<RicetteConStep> listRicetteBaseConStep = new ArrayList<>();
		List<Ricetta> listRicettaBase = ricettaService.getRicettaBase();
		for(int i = 0; i < listRicettaBase.size(); i++) {
			RicetteConStep ricettaConStep = new RicetteConStep(listRicettaBase.get(i), stepService.findAllByRicettaId(listRicettaBase.get(i).getId()));
			listRicetteBaseConStep.add(ricettaConStep);
		}
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), listRicetteBaseConStep));
	}
}
