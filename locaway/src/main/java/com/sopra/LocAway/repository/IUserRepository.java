package com.sopra.LocAway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.LocAway.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);

}
