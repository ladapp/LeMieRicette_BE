package com.le.mie.ricette.LeMieRicette.services;

import com.le.mie.ricette.LeMieRicette.entities.User;

public interface RegisterService {
	
	//Metodo per la registrazione di un nuovo utente.
	boolean InserisciUtente(String nome, String cognome, String email, String password);

}
