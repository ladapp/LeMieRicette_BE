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
import com.le.mie.ricette.LeMieRicette.services.RicetteIngredientsService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class RicetteIngredientsController {
	@Autowired
	RicetteIngredientsService ricetteIngredientsService;

	private static final Logger log = LoggerFactory.getLogger(RicetteIngredientsController.class);
	
	@RequestMapping(value="/addIngredientiRicetta", method=POST)
	public ResponseEntity<JsonResponseBody> addIngredientiRicetta(@RequestParam(value="idRicetta") int idRicetta, @RequestParam(value="idIngrediente") int idIngrediente){
		log.info("Request: /addIngredientiRicetta");
		try {
			ricetteIngredientsService.addRicettaIngredients(idRicetta, idIngrediente);
			return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), "Inserimento avvenuto con successo"));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "ERRORE: " + e.toString()));
		}
	}
}
