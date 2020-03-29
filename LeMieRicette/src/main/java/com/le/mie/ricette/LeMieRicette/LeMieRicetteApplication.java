package com.le.mie.ricette.LeMieRicette;

import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.le.mie.ricette.LeMieRicette.daos.IngredienteDao;
import com.le.mie.ricette.LeMieRicette.daos.RicettaDao;
import com.le.mie.ricette.LeMieRicette.daos.UserDao;
import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;
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
	
	@Autowired
	IngredienteDao ingredienteDao;
	
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
		/*
		ingredienteDao.save(new Ingrediente("1", "Aglio"));
		ingredienteDao.save(new Ingrediente("2", "Acciughe"));
		ingredienteDao.save(new Ingrediente("3", "Alici"));
		ingredienteDao.save(new Ingrediente("4", "Acqua"));
		ingredienteDao.save(new Ingrediente("5", "Acqua frizzante"));
		ingredienteDao.save(new Ingrediente("6", "Dado"));
		ingredienteDao.save(new Ingrediente("7", "Burro"));
		ingredienteDao.save(new Ingrediente("8", "Uova"));
		ingredienteDao.save(new Ingrediente("9", "Tuorlo"));
		ingredienteDao.save(new Ingrediente("10", "Albume"));
		ingredienteDao.save(new Ingrediente("11", "Zucchero"));
		ingredienteDao.save(new Ingrediente("12", "Farina"));
		ingredienteDao.save(new Ingrediente("13", "Sale"));
		ingredienteDao.save(new Ingrediente("14", "Pepe"));
		ingredienteDao.save(new Ingrediente("15", "Curcuma"));
		ingredienteDao.save(new Ingrediente("16", "Origano"));
		ingredienteDao.save(new Ingrediente("17", "Paprika"));
		ingredienteDao.save(new Ingrediente("18", "Salvia"));
		ingredienteDao.save(new Ingrediente("19", "Marmellata"));
		ingredienteDao.save(new Ingrediente("20", "Farina 0"));
		ingredienteDao.save(new Ingrediente("21", "Farina 00"));
		ingredienteDao.save(new Ingrediente("22", "Farina di Manitoba"));
		ingredienteDao.save(new Ingrediente("23", "Farina di Mais"));
		ingredienteDao.save(new Ingrediente("24", "Semola"));
		ingredienteDao.save(new Ingrediente("25", "Lievito per Dolci"));
		ingredienteDao.save(new Ingrediente("26", "Lievito di Birra"));
		ingredienteDao.save(new Ingrediente("27", "Lievito Secco"));
		ingredienteDao.save(new Ingrediente("28", "Ammoniaca per dolci"));
		ingredienteDao.save(new Ingrediente("29", "Zucchero a velo"));
		ingredienteDao.save(new Ingrediente("30", "Miele"));
		ingredienteDao.save(new Ingrediente("31", "Confettura"));
		ingredienteDao.save(new Ingrediente("32", "Amarena"));
		ingredienteDao.save(new Ingrediente("33", "Sciroppo di Amarena"));
		ingredienteDao.save(new Ingrediente("34", "Maionese"));
		ingredienteDao.save(new Ingrediente("35", "Ketchup"));
		ingredienteDao.save(new Ingrediente("36", "Salsa Rosa"));
		ingredienteDao.save(new Ingrediente("37", "Salsa Messicana"));
		ingredienteDao.save(new Ingrediente("38", "Salsa Barbecue"));
		ingredienteDao.save(new Ingrediente("39", "Pomodori"));
		ingredienteDao.save(new Ingrediente("40", "Peperoni"));
		ingredienteDao.save(new Ingrediente("41", "Passata di pomodoro"));
		ingredienteDao.save(new Ingrediente("42", "Pomodoro pelato"));
		ingredienteDao.save(new Ingrediente("43", "Patè di olive"));
		ingredienteDao.save(new Ingrediente("44", "Limone"));
		ingredienteDao.save(new Ingrediente("45", "Alloro"));
		ingredienteDao.save(new Ingrediente("46", "Zucchina"));
		ingredienteDao.save(new Ingrediente("47", "Carota"));
		ingredienteDao.save(new Ingrediente("48", "Melanzana"));
		ingredienteDao.save(new Ingrediente("49", "Radicchio"));
		ingredienteDao.save(new Ingrediente("50", "Cavolfiore"));
		ingredienteDao.save(new Ingrediente("51", "Broccoli"));
		ingredienteDao.save(new Ingrediente("52", "Cetriolo"));
		ingredienteDao.save(new Ingrediente("53", "Fette Biscottate"));
		ingredienteDao.save(new Ingrediente("54", "Zucca"));
		ingredienteDao.save(new Ingrediente("55", "Fiore di zucca"));
		ingredienteDao.save(new Ingrediente("56", "Mozzarella"));
		ingredienteDao.save(new Ingrediente("57", "Parmigiano"));
		ingredienteDao.save(new Ingrediente("58", "Pecorino"));
		ingredienteDao.save(new Ingrediente("59", "Emmental"));
		ingredienteDao.save(new Ingrediente("60", "Gorgonzola"));
		ingredienteDao.save(new Ingrediente("61", "Sottiletta"));
		ingredienteDao.save(new Ingrediente("62", "Robiola"));
		ingredienteDao.save(new Ingrediente("63", "Stracchino"));
		ingredienteDao.save(new Ingrediente("64", "Fagioli"));
		ingredienteDao.save(new Ingrediente("65", "Ceci"));
		ingredienteDao.save(new Ingrediente("66", "Lenticchie"));
		ingredienteDao.save(new Ingrediente("67", "Fagiolini"));
		ingredienteDao.save(new Ingrediente("68", "Fagioli Cannellini"));
		ingredienteDao.save(new Ingrediente("69", "Fagioli Borlotti"));
		ingredienteDao.save(new Ingrediente("70", "Piselli"));
		ingredienteDao.save(new Ingrediente("71", "Caffè"));
		ingredienteDao.save(new Ingrediente("72", "Spaghetti"));
		ingredienteDao.save(new Ingrediente("73", "Penne rigate"));
		ingredienteDao.save(new Ingrediente("74", "Penne lisce"));
		ingredienteDao.save(new Ingrediente("75", "Pennette rigate"));
		ingredienteDao.save(new Ingrediente("76", "Pennette lisce"));
		ingredienteDao.save(new Ingrediente("77", "Pangrattato"));
		ingredienteDao.save(new Ingrediente("78", "Besciamella"));
		ingredienteDao.save(new Ingrediente("79", "Panna da cucina"));
		ingredienteDao.save(new Ingrediente("80", "Panna da montare"));
		ingredienteDao.save(new Ingrediente("81", "Mezze maniche"));
		ingredienteDao.save(new Ingrediente("82", "Rigatoni"));
		ingredienteDao.save(new Ingrediente("83", "Farfalle"));
		ingredienteDao.save(new Ingrediente("84", "Farfalline"));
		ingredienteDao.save(new Ingrediente("85", "Linguine"));
		ingredienteDao.save(new Ingrediente("86", "Bucatini"));
		ingredienteDao.save(new Ingrediente("87", "Fettuccine"));
		ingredienteDao.save(new Ingrediente("88", "Gnocchi"));
		ingredienteDao.save(new Ingrediente("89", "Sagnette"));
		ingredienteDao.save(new Ingrediente("90", "Pasta sfoglia"));
		ingredienteDao.save(new Ingrediente("91", "Piadina"));
		ingredienteDao.save(new Ingrediente("92", "Riso"));
		ingredienteDao.save(new Ingrediente("93", "Farro"));
		ingredienteDao.save(new Ingrediente("94", "Orzo"));
		ingredienteDao.save(new Ingrediente("95", "Peperoncino"));
		ingredienteDao.save(new Ingrediente("96", "Cipolla"));
		ingredienteDao.save(new Ingrediente("97", "Rosmarino"));
		ingredienteDao.save(new Ingrediente("98", "Timo"));
		ingredienteDao.save(new Ingrediente("99", "Prezzemolo"));
		ingredienteDao.save(new Ingrediente("100", "Basilico"));
		ingredienteDao.save(new Ingrediente("101", "Sedano"));
		ingredienteDao.save(new Ingrediente("102", "Risoni"));
		ingredienteDao.save(new Ingrediente("103", "Ditalini rigati"));
		ingredienteDao.save(new Ingrediente("104", "Maccaroni"));
		ingredienteDao.save(new Ingrediente("105", "Cotechino"));
		ingredienteDao.save(new Ingrediente("106", "Pancetta"));
		ingredienteDao.save(new Ingrediente("107", "Guanciale"));
		ingredienteDao.save(new Ingrediente("108", "Speck"));
		ingredienteDao.save(new Ingrediente("109", "Prosciutto cotto"));
		ingredienteDao.save(new Ingrediente("110", "Salame"));
		ingredienteDao.save(new Ingrediente("111", "Prosciutto crudo"));
		ingredienteDao.save(new Ingrediente("112", "Mortadella"));
		ingredienteDao.save(new Ingrediente("113", "Montana"));
		ingredienteDao.save(new Ingrediente("114", "Funghi"));
		ingredienteDao.save(new Ingrediente("115", "Pane"));
		ingredienteDao.save(new Ingrediente("116", "Crostini"));
		ingredienteDao.save(new Ingrediente("117", "Pollo"));
		ingredienteDao.save(new Ingrediente("118", "Arista"));
		ingredienteDao.save(new Ingrediente("119", "Bistecca di suino"));
		ingredienteDao.save(new Ingrediente("120", "Bistecca di vitello"));
		ingredienteDao.save(new Ingrediente("121", "Straccetti"));
		ingredienteDao.save(new Ingrediente("122", "Macinato"));
		ingredienteDao.save(new Ingrediente("123", "Cosce di pollo"));
		ingredienteDao.save(new Ingrediente("124", "Alette di pollo"));
		ingredienteDao.save(new Ingrediente("125", "Petto di pollo"));
		ingredienteDao.save(new Ingrediente("126", "Salsicce di maiale"));
		ingredienteDao.save(new Ingrediente("127", "Salsicce di fegato"));
		ingredienteDao.save(new Ingrediente("128", "Salsicce di pollo"));
		ingredienteDao.save(new Ingrediente("129", "Tacchino"));
		ingredienteDao.save(new Ingrediente("130", "Salsicce di tacchino"));
		ingredienteDao.save(new Ingrediente("131", "Girello"));
		ingredienteDao.save(new Ingrediente("132", "Costatine di maiale"));
		ingredienteDao.save(new Ingrediente("133", "Coniglio"));
		ingredienteDao.save(new Ingrediente("134", "Agnello"));
		ingredienteDao.save(new Ingrediente("135", "Costatine di pecora"));
		ingredienteDao.save(new Ingrediente("136", "Capocollo di maiale"));
		ingredienteDao.save(new Ingrediente("137", "Filetto di maialle"));
		ingredienteDao.save(new Ingrediente("138", "Spalla di maiale"));
		ingredienteDao.save(new Ingrediente("139", "Budello di maiale"));
		ingredienteDao.save(new Ingrediente("140", "Stinco di maiale"));
		ingredienteDao.save(new Ingrediente("141", "Lardo"));
		ingredienteDao.save(new Ingrediente("142", "Lardo di colonnata"));
		ingredienteDao.save(new Ingrediente("143", "Cotenna di maiale"));
		ingredienteDao.save(new Ingrediente("144", "Sottofiletto di maiale"));
		ingredienteDao.save(new Ingrediente("145", "Quaglia"));
		ingredienteDao.save(new Ingrediente("146", "Anatra"));
		ingredienteDao.save(new Ingrediente("147", "Oca"));
		ingredienteDao.save(new Ingrediente("148", "Faraona"));
		ingredienteDao.save(new Ingrediente("149", "Cinghiale"));
		ingredienteDao.save(new Ingrediente("150", "Cervo"));
		*/
		ingredienteDao.save(new Ingrediente("Gallina"));
	}
	
	@Bean
	public BasicTextEncryptor textEncryptor() {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("mySecretEncryptionKeyBlaBla123");
		return textEncryptor;
	}

}
	