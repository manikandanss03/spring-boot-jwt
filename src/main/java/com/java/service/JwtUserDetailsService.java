package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.entity.UserEntity;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserService us;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username != null) {
			String passwordEncoder = getPasswordEncoderByUserName(username);
			if (passwordEncoder != null) {
				return new User(username, passwordEncoder, new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("User name and password is invalid : " + username);
			}
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	public String getPasswordEncoderByUserName(String username) {
		UserEntity ue = us.getUserInfo(username);
		if(ue != null) {
			return ue.getEncryptedPassword();
		}
		return null;
	}

}