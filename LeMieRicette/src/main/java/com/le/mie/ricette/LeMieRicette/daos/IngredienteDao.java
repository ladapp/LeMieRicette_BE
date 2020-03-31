package com.le.mie.ricette.LeMieRicette.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;

public interface IngredienteDao extends JpaRepository<Ingrediente, String>{
	
	@Query(value = "SELECT * FROM ingredienti WHERE id=:id", nativeQuery = true)
	Ingrediente findIngredientById(@Param("id") String id);
}
