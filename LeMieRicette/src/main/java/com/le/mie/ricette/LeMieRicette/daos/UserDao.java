package com.le.mie.ricette.LeMieRicette.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.le.mie.ricette.LeMieRicette.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	Optional<User> findById(String id);
	Optional<User> findByEmail(String email);
}
