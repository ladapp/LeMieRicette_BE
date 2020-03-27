package com.le.mie.ricette.LeMieRicette.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.le.mie.ricette.LeMieRicette.JsonResponseBody.JsonResponseBody;
import com.le.mie.ricette.LeMieRicette.services.IngredienteService;

@RestController
public class IngredienteController {
	
	@Autowired
	IngredienteService ingredienteService;

	private static final Logger log = LoggerFactory.getLogger(IngredienteController.class);
	
	@RequestMapping("/listaIngredienti")
	public ResponseEntity<JsonResponseBody> getAllIngredients(){
		log.info("/listaIngredienti");
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ingredienteService.getAllIngrediente()));
	}
}
