package com.le.mie.ricette.LeMieRicette.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.le.mie.ricette.LeMieRicette.entities.Ricetta;

public interface RicettaDao extends JpaRepository<Ricetta, String>{
	@Query(value = "SELECT * FROM ricette", nativeQuery = true)
	List<Ricetta> findAllRicette();
	
	@Query(value = "SELECT * FROM ricette WHERE FK_ACCOUNT=:account", nativeQuery = true)
	List<Ricetta> findAllRicetteByAccount(@Param("account") String account);
	
	@Query(value = "SELECT * FROM ricette WHERE FK_ACCOUNT IS NULL", nativeQuery = true)
	List<Ricetta> findAllRicettaBase();
	
	@Query(value="SELECT COUNT(ID) FROM ricette", nativeQuery = true)
	int getNumberOfRicette();
}
