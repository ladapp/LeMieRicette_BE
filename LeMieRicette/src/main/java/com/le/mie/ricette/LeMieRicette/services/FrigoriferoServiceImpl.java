package com.le.mie.ricette.LeMieRicette.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.le.mie.ricette.LeMieRicette.daos.UserIngredientsDao;

@Service
public class FrigoriferoServiceImpl {
	
	@Autowired
	UserIngredientsDao userIngredientsDao;

}
