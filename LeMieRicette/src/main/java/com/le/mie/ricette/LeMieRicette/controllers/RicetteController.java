package com.le.mie.ricette.LeMieRicette.controllers;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.le.mie.ricette.LeMieRicette.JsonResponseBody.JsonResponseBody;
import com.le.mie.ricette.LeMieRicette.services.RicettaService;

@RestController
public class RicetteController {

	private static final Logger log = LoggerFactory.getLogger(RicetteController.class);
	
	@Autowired
	RicettaService ricettaService;
	
	@RequestMapping("/ricetteBase")
	public ResponseEntity<JsonResponseBody> findAllRicetteBase() throws UnsupportedEncodingException {
		log.info("/ricetteBase");
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ricettaService.getRicettaBase()));
	}
}
