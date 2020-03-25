package com.le.mie.ricette.LeMieRicette.services;

import java.util.Optional;

import com.le.mie.ricette.LeMieRicette.entities.User;

public interface UserService {

	Optional<User> findById(String id);
}
