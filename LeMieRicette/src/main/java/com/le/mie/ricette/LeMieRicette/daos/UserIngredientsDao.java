package com.le.mie.ricette.LeMieRicette.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.le.mie.ricette.LeMieRicette.entities.UserIngredients;

public interface UserIngredientsDao extends JpaRepository<UserIngredients, Integer>{

}
