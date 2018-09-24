package com.training.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.training.service.UserService;

import model.User;

@Controller
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/helloWorld")
	public ModelAndView hello() {
		String message = "hello.";
		ModelAndView mv = new ModelAndView("helloWorld");
		mv.addObject("message", message);
		return mv;
	}

	@RequestMapping(value = "/login")
	public ModelAndView getLoginPage() {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping(value="/loginProcess")
	public ModelAndView submitLogin(@ModelAttribute("user") User user){
		if(userService.validateUser(user.getUserName(), user.getPassword()) != null){
			ModelAndView modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("user", user);
			return modelAndView;
			
		}
		return new ModelAndView("login","message","Invalid credentials");
	}
	
	@RequestMapping("/registration")
	public ModelAndView getRegistrationPage(){
		ModelAndView modelAndView = new ModelAndView("registration");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping("/registerProcess")
	public ModelAndView submitRegistration(@ModelAttribute("user") User user){
		userService.register(user);
		
		return new ModelAndView("registrationSuccess");
		
	}
}
