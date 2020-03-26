package com.le.mie.ricette.LeMieRicette.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.le.mie.ricette.LeMieRicette.entities.User;
import com.le.mie.ricette.LeMieRicette.utils.UserNotLoggedException;


public interface LoginService {

	Optional<User> getUserFromDbAndVerifyPassword(String id, String password)throws UserNotLoggedException;
    //-> userDao.findById(id), encryptionUtils.decrypt(pwd) -> UserNotLoggedException

    String createJwt(String subject, String name, String permission, Date date) throws UnsupportedEncodingException;
    //-> JwtUtils.generateJwt(...) 						 -> UnsupportedEncodingException


    Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws UserNotLoggedException, UnsupportedEncodingException;
    //-> JwtUtils.getJwtFromHttpRequest(request)		-> UserNotLoggedException
    // 	  -> JwtUtils.jwt2Map(jwt)						-> UnsupportedEncodingException
    //												->  ExpiredJwtException
    
    Optional<User> getUserById(String id);
    Optional<User> getUserFromDbByEmailAndVerifyPassword(String email, String password)throws UserNotLoggedException;
}
