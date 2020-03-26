package com.le.mie.ricette.LeMieRicette;

import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.le.mie.ricette.LeMieRicette.daos.RicettaDao;
import com.le.mie.ricette.LeMieRicette.daos.UserDao;
import com.le.mie.ricette.LeMieRicette.entities.Ricetta;
import com.le.mie.ricette.LeMieRicette.entities.User;
import com.le.mie.ricette.LeMieRicette.utils.EncryptionUtils;


@SpringBootApplication
public class LeMieRicetteApplication implements CommandLineRunner{
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RicettaDao ricettaDao;
	
	@Autowired
	EncryptionUtils encryptionUtils;
	
	private static final Logger log = LoggerFactory.getLogger(LeMieRicetteApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LeMieRicetteApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Hello 1");
		/*
		String encryptedPwd = encryptionUtils.encrypt("ciao123");
		log.info("Ecripted pwd into DB: " + encryptedPwd);
		userDao.save(new User("1", "Davide", "Simboli", "davide.simboli@gmail.com", encryptedPwd, "admin"));
		
		encryptedPwd = encryptionUtils.encrypt("ciao2");
		userDao.save(new User("2", "Alessio", "Morgante", "alessio.morgante@email.it", encryptedPwd, "user"));
		
		encryptedPwd = encryptionUtils.encrypt("ciao3");
		userDao.save(new User("3", "Loreto", "Cicerone", "loreto.cicerone@email.it", encryptedPwd, "user"));
		
		ricettaDao.save(new Ricetta("1", "Carbonara"));
		ricettaDao.save(new Ricetta("2", "Pollo"));
		ricettaDao.save(new Ricetta("3", "Insalata"));
		ricettaDao.save(new Ricetta("4", "Tiramisù"));
		
		ricettaDao.save(new Ricetta("5", "Matriciana", "1"));
		ricettaDao.save(new Ricetta("6", "Ciambellone", "1"));
		ricettaDao.save(new Ricetta("7", "Crostata", "2"));
		ricettaDao.save(new Ricetta("8", "Minestra", "2"));
		ricettaDao.save(new Ricetta("9", "Fagioli in salsa", "3"));
		ricettaDao.save(new Ricetta("10", "Biscotti", "3"));*/
	}
	
	@Bean
	public BasicTextEncryptor textEncryptor() {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("mySecretEncryptionKeyBlaBla123");
		return textEncryptor;
	}

}
	