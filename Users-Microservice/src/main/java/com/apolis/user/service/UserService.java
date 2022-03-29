package com.apolis.user.service;

import java.util.List;

import com.apolis.user.entity.User;

public interface UserService {
	List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String userName);
    User saveUser(User user);
}
