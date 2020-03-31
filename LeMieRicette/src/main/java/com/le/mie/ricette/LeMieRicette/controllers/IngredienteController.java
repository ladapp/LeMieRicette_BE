package com.le.mie.ricette.LeMieRicette.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
import com.le.mie.ricette.LeMieRicette.daos.IngredienteDao;
import com.le.mie.ricette.LeMieRicette.daos.UserIngredientsDao;
import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;
import com.le.mie.ricette.LeMieRicette.entities.UserIngredients;
import com.le.mie.ricette.LeMieRicette.services.IngredienteService;

@RestController
public class IngredienteController {
	
	@Autowired
	IngredienteService ingredienteService;
	
	@Autowired
	UserIngredientsDao userIngredientsDao;
	
	@Autowired
	IngredienteDao ingredienteDao;

	private static final Logger log = LoggerFactory.getLogger(IngredienteController.class);
	
	@RequestMapping("/listaIngredienti")
	public ResponseEntity<JsonResponseBody> getAllIngredients(){
		log.info("/listaIngredienti");
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ingredienteService.getAllIngrediente()));
	}
	
	@RequestMapping(value = "/salvaIngredienti", method = POST)
	public ResponseEntity<JsonResponseBody> saveIngredientsOfUser(@RequestParam(value = "idUser") String idUser, @RequestParam(value = "idIngrediente") String idIngrediente){
		log.info("/salvaIngredienti");
		userIngredientsDao.save(new UserIngredients(idUser, idIngrediente));
		
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), "Ingredienti associati all'utente"));
	}
	
	@RequestMapping(value = "/ingredientPerUser/{userId}")
	public ResponseEntity<JsonResponseBody> getAllIngredientPerUser(@PathVariable(name = "userId") String userId){
		List<UserIngredients> userIngredientsList = ingredienteService.getAllIngredientPerUser(userId);
		List<Ingrediente> ingredienti = new ArrayList<Ingrediente>();
		for (UserIngredients userIngredients : userIngredientsList) {
			ingredienti.add(ingredienteDao.findIngredientById(userIngredients.getIngredients_id()));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ingredienti));
	}
	
	@RequestMapping(value = "/deleteIngredientUser", method = POST)
	public ResponseEntity<JsonResponseBody> deleteIngredientUser(@RequestParam(value="userId") String userId, @RequestParam(value="ingredientId") String ingredientId){
		ingredienteService.deleteIngredientUser(userId, ingredientId);
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), "Ingrediente eliminato"));
	}
}
