package com.aurora.user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurora.user.entities.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
	List<UserDetails> findUserByName(String name);
}
