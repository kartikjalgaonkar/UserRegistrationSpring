package com.training.dao.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.training.dao.UserDao;

import model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

	@InjectMocks
	UserDao userDao;
	
	@Mock
	EntityManager entityManager;
	
	@Mock
	Query query;
	
	@Test
	public void shouldAddUserInDatabase(){
		User user = new User();
		user.setUserId(1);
		user.setMobileNumber(234123412L);
		user.setEmailId("kartik.j");
		Mockito.doNothing().when(entityManager).persist(user);
		int actual = userDao.addUser(user);
		Assert.assertEquals(1, actual);
		Mockito.verify(entityManager).persist(user);
	}
	
	@Test
	public void shouldValidateUser(){
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setUserName("asdf");
		list.add(user);
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(entityManager.createQuery(Mockito.anyString()).getResultList()).thenReturn(list);
		
		User actual = userDao.validateUser("kartik", "asdf");
		Assert.assertEquals(user, actual);
		Mockito.verify(entityManager, Mockito.times(2)).createQuery(Mockito.anyString());
	}
	
	@Test
	public void shouldReturnNullForInvalidUser(){
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setUserName("asdf");
		Mockito.when(entityManager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(entityManager.createQuery(Mockito.anyString()).getResultList()).thenReturn(list);
		
		Assert.assertNull(userDao.validateUser("Kartik", "Kartik"));
		Mockito.verify(entityManager, Mockito.times(2)).createQuery(Mockito.anyString());
	}
	

}
