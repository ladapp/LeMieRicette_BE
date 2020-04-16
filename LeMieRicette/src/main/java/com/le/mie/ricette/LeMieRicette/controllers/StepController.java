package com.le.mie.ricette.LeMieRicette.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.le.mie.ricette.LeMieRicette.JsonResponseBody.JsonResponseBody;
import com.le.mie.ricette.LeMieRicette.services.StepService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class StepController {

	private static final Logger log = LoggerFactory.getLogger(StepController.class);
	
	@Autowired
	StepService stepService;
	
	@RequestMapping(value="/addRicettaStep", method=POST)
	public ResponseEntity<JsonResponseBody> addRicettaStep(@RequestParam(value="idRicetta") int idRicetta, @RequestParam(value="num") int num, @RequestParam(value="descrizione") String descrizione){
		log.info("Request: /addRicettaStep");
		try {
			stepService.addRicettaStep(idRicetta, num, descrizione);
			return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), "inserimento avvenuto con successo"));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "ERRORE: " + e.toString()));
		}
	}
}
