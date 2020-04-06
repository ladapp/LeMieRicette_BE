package com.le.mie.ricette.LeMieRicette.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.le.mie.ricette.LeMieRicette.entities.Step;

public interface StepDao extends JpaRepository<Step, Integer>{
	
	@Query(value = "SELECT * FROM steps WHERE id_ricetta=:ricettaId", nativeQuery = true)
	List<Step> getAllStepByRicettaId(@Param("ricettaId") int ricettaId);

}
