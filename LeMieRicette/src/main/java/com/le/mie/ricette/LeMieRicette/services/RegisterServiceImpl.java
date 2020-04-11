package com.le.mie.ricette.LeMieRicette.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.le.mie.ricette.LeMieRicette.daos.UserDao;
import com.le.mie.ricette.LeMieRicette.entities.User;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean InserisciUtente(String nome, String cognome, String email, String password) {
		
		// TODO Auto-generated method stub
		userDao.save(new User(nome, cognome, email, password, "user"));
		
		return true;
		
	}
	
}
