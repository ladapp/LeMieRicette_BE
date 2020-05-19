package com.le.mie.ricette.LeMieRicette.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.le.mie.ricette.LeMieRicette.daos.RicettaDao;
import com.le.mie.ricette.LeMieRicette.entities.Ricetta;

@Service
public class RicettaServiceImpl implements RicettaService{
		
	@Autowired
	RicettaDao ricettaDao;
	
	@Autowired
	EntityManager entitymanager;


	@Override
	public List<Ricetta> getAllRicetta() {
		
		return ricettaDao.findAll();
	}

	@Override
	public List<Ricetta> getAllRicettaPerUser(String userId) {
		return ricettaDao.findAllRicetteByAccount(userId);
	}

	@Override
	public Ricetta saveRicetta(Ricetta ricetta) {
		return ricettaDao.save(ricetta);
	}

	@Override
	public List<Ricetta> getRicettaBase() {
		return ricettaDao.findAllRicettaBase();
	}

	@Override
	public int getNumberOfRicette() {
		return ricettaDao.getNumberOfRicette();
	}
		
	@Override
	public List<Integer> getIDfromIngredients(ArrayList<Object> list) {
		
		
		String query="SELECT distinct id_ricetta FROM ricette_ingredienti JOIN ingredienti "
				+ "on (ingredienti.ID=ricette_ingredienti.id_ingrediente) where";
			 
		for(Object obj : list) {
			
			if(list.size()==1) {
				query = query + " ingredienti.NOME_INGREDIENTE = '" + obj.toString() + "' ";
			}
			
		else {
		query = query + " ingredienti.NOME_INGREDIENTE = '" + obj.toString() + "' OR";
			
			}
		
	}
		
		if(query.substring(query.length()-2, query.length()).toUpperCase().equals("OR")) 
		    
		    {
	    
			StringBuilder str = new StringBuilder(query);
			str.replace(query.length()-2, query.length(), " ");
			
			String result=str.toString();
			
			
	     try 
		    {
				 
			 Query getLista = entitymanager.createNativeQuery(result);
			 
			 List<Integer> listaRicette = getLista.getResultList();
			 
			 for(Integer idRicetta : listaRicette) 
			 {
			 
			 System.out.println(idRicetta);
		 
			 }
			 //this.getRicetteByIngredients(listaRicette);
			 return listaRicette;
			  
			}  
	      catch(NoResultException nre) 
	           {
		  System.out.println(nre.toString());
		  return null;
			   }
		    }
		    else {
		    	try {
		    	Query getLista = entitymanager.createNativeQuery(query);
		    	
		    	List<Integer> listaRicette = getLista.getResultList();
		    	
		    //	this.getRicetteByIngredients(listaRicette);
				return listaRicette;
			}
		      
		    	catch(NoResultException ex) {
				System.out.println(ex.toString());
				return null;
			}
		    }
	}

	@Override
	public ArrayList<Ricetta> getRicetteByIngredients(List<Object> list) {
		
		ArrayList<Ricetta> listaRicette = new ArrayList<Ricetta>();
		
		System.out.println("Sono nel for per prendere le ricette");
		for(Object id_ricetta : list)
		{     
			System.out.println("Itero");


	     Ricetta ricetta = new Ricetta();
	     ricetta = ricettaDao.getRicettaByID(id_ricetta);
	     listaRicette.add(ricetta);
		}
		System.out.println("Tutto ok");
		for(Ricetta ricetta : listaRicette) {
			System.out.println("Nome:" + ricetta.getNomeRicetta());
		}
		return listaRicette;
	}
	
	@Override
	public Ricetta getRicettaById(int ricettaId) {
		return ricettaDao.findRicettaById(ricettaId);
	}
	
	@Override
	public List<Ricetta> getRicettePerPortata(String userId, String ricettaPortata) {
		return ricettaDao.findRicettaByPortata(userId, ricettaPortata);
	}
	
	@Override
	public List<Ricetta> getRicetteBasePerPortata (String ricettaPortata){
		return ricettaDao.findRicettaBaseByPortata(ricettaPortata);
	}
	
	@Override
	public void deleteRicetta(int ricettaId) {
		ricettaDao.deleteRicettaUser(ricettaId);
	}
	
	
}
