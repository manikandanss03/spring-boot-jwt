package com.java.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	 UserEntity findByEmail(String email);
	 
	 List<UserEntity> findByIsActiveTrue();

}
