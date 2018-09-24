package com.training.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.UserDao;

import model.User;

@Service(value = "userService")
public class UserService {
	@Autowired
	UserDao userDao;
	
	@Transactional
	public Integer register(User user) {
		return userDao.addUser(user);
	}

	public User validateUser(String userName, String password) {
		return userDao.validateUser(userName, password);
	}
}
