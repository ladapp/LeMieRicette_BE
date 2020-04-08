package com.le.mie.ricette.LeMieRicette.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.le.mie.ricette.LeMieRicette.entities.RicetteIngredients;

public interface RicetteIngredientsDao extends JpaRepository<RicetteIngredients, Integer>{

}
