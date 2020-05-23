package com.le.mie.ricette.LeMieRicette.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.le.mie.ricette.LeMieRicette.JsonResponseBody.JsonResponseBody;
import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;
import com.le.mie.ricette.LeMieRicette.entities.Ricetta;
import com.le.mie.ricette.LeMieRicette.entities.User;
import com.le.mie.ricette.LeMieRicette.services.LoginService;
import com.le.mie.ricette.LeMieRicette.services.RegisterService;
import com.le.mie.ricette.LeMieRicette.services.RicettaService;
import com.le.mie.ricette.LeMieRicette.services.UserService;
import com.le.mie.ricette.LeMieRicette.utils.EncryptionUtils;
import com.le.mie.ricette.LeMieRicette.utils.UserNotLoggedException;
import com.le.mie.ricette.LeMieRicette.validators.UserValidator;

import io.jsonwebtoken.ExpiredJwtException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	private static final Logger log = LoggerFactory.getLogger(RestController.class);
	
	@Autowired
	EncryptionUtils encryptionUtils;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	RegisterService registerService;
	
	@Autowired
	RicettaService ricettaService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		log.info("Request /hello");
		return "Ciao a tutti!";
	}
	
	@RequestMapping("/newUser1")
	public String addUser(User user) {
		return "Utente aggiunto: " + user.getId() +", "+ user.getEmail();
	}
	
	@RequestMapping("/newUser2")
	public String addUserValid(@Valid User user) {
		log.info("Request /newUser2");
		return "User added correctly: " + user.getId() + ", " + user.getEmail();
	}
	
	@RequestMapping("/newUser3")
	public String addUserValidPlusBinding(@Valid User user, BindingResult result) {
		log.info("Request /newUser3");
		if(result.hasErrors()) {
			return result.toString();
		}
		return "User added correctly: " + user.getId() + ", " + user.getEmail();
	}
	
	@RequestMapping("/newUser4")
	public String addUserValidPlusBinding2(User user, BindingResult result) {
		log.info("Request /newUser4");
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, result);
		
		if(result.hasErrors()) {
			return result.toString();
		}
		return "User added correctly: " + user.getId() + ", " + user.getEmail();
	}
	
	@RequestMapping(value = "/login", method = POST)
    public ResponseEntity<JsonResponseBody> loginUser(@RequestParam(value = "email") String email, @RequestParam(value="password") String pwd){
		log.info("Request /login");
		try {
    		//Optional<User> userr = loginService.getUserFromDbAndVerifyPassword(id, pwd);
    		Optional<User> userr = loginService.getUserFromDbByEmailAndVerifyPassword(email, pwd);
    		if(userr.isPresent()) {
    			User user = userr.get();
    			String jwt = loginService.createJwt(user.getId(), user.getEmail(), user.getPermission(), new Date());
    			return ResponseEntity.status(HttpStatus.OK).header("jwt", jwt).body(new JsonResponseBody(HttpStatus.OK.value(), user, jwt));
    		}
    	}catch(UserNotLoggedException e1) {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Login failed! Wrong credentials! "+e1.toString()));
    	}catch(UnsupportedEncodingException e2) {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "TOKEN ERROR "+e2.toString()));
    	}
    	
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "No corrispondence in the database of users!"));
	}
	
	
	@RequestMapping("/operations/account/{account}")
    public ResponseEntity<JsonResponseBody> fetchAllOperationsPerAccount(HttpServletRequest request, @PathVariable(name = "account") String account){
    	return null;
    }
    
    @RequestMapping(value = "/ricette", method =POST)
    public ResponseEntity<JsonResponseBody> fetchAllAccountsPerUser(HttpServletRequest request){
    	log.info("Request /accounts/user");
    	try {
    		Map<String, Object> userData = loginService.verifyJwtAndGetData(request);
    		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ricettaService.getAllRicetta()));
    	}catch(UnsupportedEncodingException e1) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Bad request "+e1.toString()));
    	}catch(UserNotLoggedException e2) {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "User not logged, Login first! "+e2.toString()));
    	}catch(ExpiredJwtException e3) {
    		return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JsonResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), "Session EXPIRED! "+e3.toString()));
    	}
    }
    
    @RequestMapping(value = "/ricette/add", method=POST)
    public ResponseEntity<JsonResponseBody> addRicetta(HttpServletRequest request, @Valid Ricetta ricetta, BindingResult bindingResult){
    	log.info("Request /ricette/add");
    	if(bindingResult.hasErrors()) {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "ERROR: invalid format of data"));
    	}
    	try {
    		Map<String, Object> userData = loginService.verifyJwtAndGetData(request);
    		Optional<User> userr = userService.findById((String) userData.get("subject"));
    		Ricetta newRicetta = ricetta;
    		newRicetta.setFkaccount(userr.get().getId());
    		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ricettaService.saveRicetta(newRicetta)));
    	}catch(UserNotLoggedException e1) {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "User not logged, Login first! "+e1.toString()));
    	}catch(UnsupportedEncodingException e2) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Bad request "+e2.toString()));
    	}catch(ExpiredJwtException e3) {
    		return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JsonResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), "Session EXPIRED! "+e3.toString()));
    	}
    }
    
    @RequestMapping(value = "/ricette/user", method = POST)
    public ResponseEntity<JsonResponseBody> fetchAllRicettePerUser(HttpServletRequest request){
    	log.info("Request /accounts/user");
    	try {
    		Map<String, Object> userData = loginService.verifyJwtAndGetData(request);
    		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), ricettaService.getAllRicettaPerUser((String) userData.get("subject"))));
    	}catch(UnsupportedEncodingException e1) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Bad request "+e1.toString()));
    	}catch(UserNotLoggedException e2) {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "User not logged, Login first! "+e2.toString()));
    	}catch(ExpiredJwtException e3) {
    		return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JsonResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), "Session EXPIRED! "+e3.toString()));
    	}
    }
    
    @RequestMapping(value = "/user/{userid}")
    public ResponseEntity<JsonResponseBody> getUser(@PathVariable(name = "userid") String userID){
    	log.info("Request /user/{userid}");
    	try {
    		//loginService.verifyJwtAndGetData(request);
    		Optional<User> user = loginService.getUserById(userID);
    		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), user));
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "User not logged, Login first! "+e.toString()));
    	}
    }
    
    /**
     * Metodo utilizzato per registrare un nuovo utente nel database chiamando l'apposito metodo.
     * @param nome
     * @param cognome
     * @param email
     * @param password
     * @return
     */
    
    @RequestMapping(value = "/register", method=POST)
    public ResponseEntity <JsonResponseBody> registerUser (@RequestParam(name ="name") String nome, @RequestParam(name ="surname") String cognome,
    		@RequestParam(name ="email") String email, @RequestParam(name ="password") String password){
    	
    	try {
    	String pwd = encryptionUtils.encrypt(password);
		
		
		registerService.InserisciUtente(nome, cognome, email, pwd);
		
		return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), "Registrazione Effettuata"));

    	}
    	catch(Exception ex) {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Registrazione fallita: "+ex.toString()));

    	}
    	
            	
    }
	
     @PostMapping(value = "/findRicette", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
     public ResponseEntity <JsonResponseBody> findRicette (@RequestBody ArrayList<Object> list){
    
 
        try {
       List<Integer> listaIdRicette = new ArrayList<Integer>();
       listaIdRicette = ricettaService.getIDfromIngredients(list);
       return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), listaIdRicette));
        	
        }
       catch(Exception ex) {
       return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Ricerca delle ricette fallita: "+ex.toString()));
        	
        } 
     }   

}
