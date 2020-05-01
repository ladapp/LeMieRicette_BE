package com.le.mie.ricette.LeMieRicette.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.le.mie.ricette.LeMieRicette.entities.Ingrediente;



public interface IngredientiRicettaDAO extends JpaRepository<Ingrediente, Integer>{
	
	@Query(value = "SELECT ingredienti.* FROM ricette_ingredienti JOIN ingredienti ON ingredienti.id=ricette_ingredienti.id_ingrediente WHERE ricette_ingredienti.id_ricetta=:ricettaId", nativeQuery = true)
	List <Ingrediente> getIngredientsByRicettaId(@Param("ricettaId") int ricettaId);

}
