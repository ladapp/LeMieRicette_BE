package com.le.mie.ricette.LeMieRicette.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;

public interface IngredienteDao extends JpaRepository<Ingrediente, String>{

	
}
