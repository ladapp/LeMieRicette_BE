package com.le.mie.ricette.LeMieRicette.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;
import com.le.mie.ricette.LeMieRicette.entities.RicetteIngredients;


public interface RicetteIngredientsDao extends JpaRepository<RicetteIngredients, Integer>{
	
}
