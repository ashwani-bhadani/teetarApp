package com.teetar.teetarApp.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.teetar.teetarApp.model.Role;
import com.teetar.teetarApp.model.TeetarUser;
import com.teetar.teetarApp.repository.RoleRepository;
import com.teetar.teetarApp.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	public TeetarUser registerUser(TeetarUser user) {
		Set<Role> roles = user.getAuthorities();
		roles.add(roleRepository.findByAuthority("TUSER11").get());
		user.setAuthorities(roles);
		
		return userRepository.save(user);
	}

}
