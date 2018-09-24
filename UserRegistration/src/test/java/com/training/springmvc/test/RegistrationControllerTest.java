package com.training.springmvc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import com.training.service.UserService;
import com.training.springmvc.RegistrationController;

import model.User;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

	@InjectMocks
	RegistrationController controller;

	@Mock
	UserService userService;

	@Test
	public void shouldReturnModelAndViewForHelloWorld() {
		//RegistrationController controller = new RegistrationController();
		assertEquals("helloWorld", controller.hello().getViewName());
	}

	@Test
	public void shouldReturnLoginPage() {
		//RegistrationController controller = new RegistrationController();
		assertEquals("login", controller.getLoginPage().getViewName());
	}

	@Test
	public void shouldReturnWelcomePage() {
		User user = new User();
		user.setUserName("Kartik");
		user.setPassword("Kartik");

		when(userService.validateUser(user.getUserName(), user.getPassword())).thenReturn(user);
		String viewName = controller.submitLogin(user).getViewName();
		assertEquals("welcome", viewName);
		Mockito.verify(userService).validateUser(user.getUserName(), user.getPassword());
	}
	
	@Test
	public void shouldReturnLoginPageIfDetailsAreIncorrect(){
		User user = new User();
		user.setUserName("Kartik");
		user.setPassword("Kartik");
		
		when(userService.validateUser(user.getUserName(), user.getPassword())).thenReturn(null);
		String viewName = controller.submitLogin(user).getViewName();
		assertEquals("login", viewName);
		Mockito.verify(userService).validateUser(user.getUserName(), user.getPassword());
	}
	
	@Test
	public void shouldReturnRegistrationView(){
		//RegistrationController controller = new RegistrationController();
		String actualView = controller.getRegistrationPage().getViewName();
		Assert.assertEquals("registration", actualView);
	}
	
	@Test
	public void shouldReturnRegistrationSuccessView(){
		User user = new User();
		String actualView = controller.submitRegistration(user).getViewName();
		Assert.assertEquals("registrationSuccess", actualView);
	}
}
