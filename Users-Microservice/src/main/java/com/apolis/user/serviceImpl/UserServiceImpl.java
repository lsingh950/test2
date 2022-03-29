package com.apolis.user.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apolis.user.entity.User;
import com.apolis.user.entity.UserRole;
import com.apolis.user.repository.UserRepository;
import com.apolis.user.repository.UserRoleRepository;
import com.apolis.user.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public User getUserByName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public User saveUser(User user) {
		user.setActive(1);
		UserRole role = userRoleRepository.findUserRoleByRoleName("ROLE_USER");
		user.setRole(role);
		return userRepository.save(user);
	}
}
