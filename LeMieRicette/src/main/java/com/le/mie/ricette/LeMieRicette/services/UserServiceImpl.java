package com.le.mie.ricette.LeMieRicette.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.le.mie.ricette.LeMieRicette.daos.UserDao;
import com.le.mie.ricette.LeMieRicette.entities.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	@Override
	public Optional<User> findById(String id) {
		Optional<User> userr = userDao.findById(id);
		if(userr.isPresent()) {
			return userr;
		}else {
			return null;
		}
	}

}
