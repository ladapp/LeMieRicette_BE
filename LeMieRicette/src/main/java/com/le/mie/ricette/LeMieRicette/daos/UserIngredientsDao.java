package com.le.mie.ricette.LeMieRicette.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.le.mie.ricette.LeMieRicette.entities.UserIngredients;

public interface UserIngredientsDao extends JpaRepository<UserIngredients, Integer>{

	@Query(value = "SELECT * FROM users_ingredients WHERE user_id=:id", nativeQuery = true)
	List<UserIngredients> findAllIngredientsByUserId(@Param("id") String id);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM users_ingredients WHERE user_id=:userId AND ingredients_id=:ingredientId", nativeQuery = true)
	void deleteIngredientsUser(@Param("userId") String userId, @Param("ingredientId") String ingredientId);
}
