package com.le.mie.ricette.LeMieRicette.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.le.mie.ricette.LeMieRicette.JsonResponseBody.JsonResponseBody;
import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;
import com.le.mie.ricette.LeMieRicette.entities.Ricetta;
import com.le.mie.ricette.LeMieRicette.entities.RicetteConStep;
import com.le.mie.ricette.LeMieRicette.services.RicettaService;
import com.le.mie.ricette.LeMieRicette.services.StepService;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
	
	@RequestMapping(value = "/ricettePerUser/{userId}")
	public ResponseEntity<JsonResponseBody> findAllRicetteByAccount(@PathVariable(name = "userId") String userId) throws UnsupportedEncodingException {
		log.info("/ricettePerUser");
		
		List<RicetteConStep> listRicetteUserConStep = new ArrayList<>();
		List<Ricetta> listRicettaUser = ricettaService.getAllRicettaPerUser(userId);
		for(int i = 0; i < listRicettaUser.size(); i++) {
			RicetteConStep ricettaConStep = new RicetteConStep(listRicettaUser.get(i), stepService.findAllByRicettaId(listRicettaUser.get(i).getId()));
			listRicetteUserConStep.add(ricettaConStep);
		}
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), listRicetteUserConStep));
	}
	
	@RequestMapping(value="/addRicetta", method=POST)
	public ResponseEntity<JsonResponseBody> addRicetta(@RequestParam(value="id") int id, @RequestParam(value="nomeRicetta") String nomeRicetta, @RequestParam(value="fkaccount") String fkaccount, 
			@RequestParam(value="portata") String portata, @RequestParam(value="persone") int persone){
		log.info("Request: /addRicetta");
		try {
			ricettaService.saveRicetta(new Ricetta(id, nomeRicetta, fkaccount, portata, null, persone));
			return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), "Inserimento avvenuto con successo"));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "ERRORE: "+e.toString()));
		}
	}
	
	@RequestMapping(value="/numberOfRicette")
	public ResponseEntity<JsonResponseBody> getNumberOfRicette(){
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ricettaService.getNumberOfRicette()));
	}
	
}
