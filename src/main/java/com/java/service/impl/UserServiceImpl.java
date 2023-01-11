package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.entity.UserEntity;
import com.java.jpa.UserRepository;
import com.java.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository ur;

	@Override
	public UserEntity addUser(UserEntity userInfo) {
		return ur.save(userInfo);
	}
	
	public UserEntity getUserInfo(String email) {
		return ur.findByEmail(email);
	}
	
	public List<UserEntity> getAllUserInfo() {
		return ur.findAll();
	}
	
	public List<UserEntity> getAllActiveUser() {
		return ur.findByIsActiveTrue();
	}
	
	public UserEntity DeleteUserInfo(String email) {
		UserEntity ue = ur.findByEmail(email);
		ue.setIsActive(false);
		return addUser(ue);
	}

}
