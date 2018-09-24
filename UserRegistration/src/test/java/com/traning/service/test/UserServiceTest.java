package com.traning.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.training.dao.UserDao;
import com.training.service.UserService;

import model.User;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	UserService userService;
	
	@Mock
	UserDao userDao;
	
	@Test
	public void shouldRegitserUser(){
		Mockito.when(userDao.addUser(Mockito.any(User.class))).thenReturn(1);
		int actual = userService.register(new User());
		Assert.assertEquals(1, actual);
	}
	
	@Test
	public void shouldValidateUser(){
		Mockito.when(userDao.validateUser(Mockito.anyString(), Mockito.anyString())).thenReturn(new User());
		userService.validateUser("kartik", "kartik");
		Mockito.verify(userDao).validateUser(Mockito.anyString(), Mockito.anyString());
	}

}
