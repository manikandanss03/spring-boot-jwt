package com.java.service;

import java.util.List;

import com.java.entity.UserEntity;

public interface UserService {
	
	UserEntity addUser(UserEntity userInfo);
	
	UserEntity getUserInfo(String email);
	
	List<UserEntity> getAllUserInfo();

}
