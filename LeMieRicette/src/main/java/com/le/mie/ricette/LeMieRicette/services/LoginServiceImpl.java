package com.le.mie.ricette.LeMieRicette.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.le.mie.ricette.LeMieRicette.daos.UserDao;
import com.le.mie.ricette.LeMieRicette.entities.User;
import com.le.mie.ricette.LeMieRicette.utils.EncryptionUtils;
import com.le.mie.ricette.LeMieRicette.utils.JwtUtils;
import com.le.mie.ricette.LeMieRicette.utils.UserNotLoggedException;

@Service
public class LoginServiceImpl implements LoginService{

	private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	EncryptionUtils encryptionUtils;
	
	@Override
	public Optional<User> getUserFromDbAndVerifyPassword(String id, String password) throws UserNotLoggedException {
		log.info("");
		Optional<User> userr = userDao.findById(id);
		if(userr.isPresent()) {
			User user = userr.get();
			if(encryptionUtils.decrypt(user.getPassword()).equals(password)) {
				log.info("Username e password verificate!");
			}else {
				log.info("User verified, password not");
				throw new UserNotLoggedException("Impossibile loggare l'utente!");
			}
		}
		return userr;
	}

	@Override
	public String createJwt(String subject, String name, String permission, Date datenow)
			throws UnsupportedEncodingException {
		Date expDate = datenow;
		expDate.setTime(datenow.getTime() + (300*1000));
		log.info("JWT Creation. Expiration time: " + expDate.getTime());
		
		String token = JwtUtils.generateJwt(subject, expDate, name, permission);
		
		return token;
	}

	@Override
	public Map<String, Object> verifyJwtAndGetData(HttpServletRequest request)
			throws UserNotLoggedException, UnsupportedEncodingException {
		String jwt = JwtUtils.getJwtFromHttpRequest(request);
		if(jwt == null) {
			throw new UserNotLoggedException("Authentication token not in the request");
		}
		Map<String, Object> userData = JwtUtils.jwt2Map(jwt);
		return userData;
	}

	@Override
	public Optional<User> getUserById(String id) {
		Optional<User> userr = userDao.findById(id);
		return userr;
	}

	@Override
	public Optional<User> getUserFromDbByEmailAndVerifyPassword(String email, String password)
			throws UserNotLoggedException {
		log.info("Login with email and password");
		Optional<User> userr = userDao.findByEmail(email);
		if(userr.isPresent()) {
			User user = userr.get();
			if(encryptionUtils.decrypt(user.getPassword()).equals(password)) {
				log.info("Username e password verificate!");
			}else {
				log.info("User verified, password not");
				throw new UserNotLoggedException("Impossibile loggare l'utente!");
			}
		}
		return userr;
	}

}
