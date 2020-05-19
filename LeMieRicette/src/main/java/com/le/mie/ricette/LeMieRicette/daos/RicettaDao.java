package com.le.mie.ricette.LeMieRicette.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

	@Query(value="SELECT * FROM ricette WHERE ricette.ID=:id", nativeQuery = true)
	Ricetta getRicettaByID(@Param("id") Object id);
	
	@Query(value = "SELECT * FROM ricette WHERE ID=:ricettaId", nativeQuery = true)
	Ricetta findRicettaById(@Param("ricettaId") int ricettaId);
	
	@Query(value = "SELECT * FROM ricette WHERE FK_ACCOUNT=:userId AND portata=:ricettaPortata", nativeQuery = true)
	List<Ricetta>findRicettaByPortata(@Param("userId") String userId, @Param("ricettaPortata") String ricettaPortata );
	
	@Query(value = "SELECT * FROM ricette WHERE FK_ACCOUNT IS NULL AND portata=:ricettaPortata", nativeQuery = true)
	List<Ricetta>findRicettaBaseByPortata(@Param("ricettaPortata") String ricettaPortata );
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM ricette WHERE id=:ricettaId", nativeQuery = true)
	void deleteRicettaUser(@Param("ricettaId") int ricettaId );

	}