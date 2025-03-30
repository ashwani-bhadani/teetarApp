package com.teetar.teetarApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teetar.teetarApp.model.TeetarUser;

@Repository
public interface UserRepository extends JpaRepository<TeetarUser, Long>{

	Optional<TeetarUser> findByUsername(String username);
	
}
