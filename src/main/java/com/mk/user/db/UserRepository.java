package com.mk.user.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
public interface UserRepository  extends CrudRepository<User, UUID> {
	Optional<User> findUserByEmail(String email);
}
