package com.janine.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.janine.entity.User;

@Controller
@RequestMapping("/login")
public class LoginControl {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("------>login");
		
        User user = new User();  
        user.setUsername("zhangsan");  
        user.setPassword("1234");  
        List<User> users = new ArrayList<User>();  
        users.add(user);  
        return new ModelAndView("user", "users", users);  
        
	}

	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public String doLogin() {
		System.out.println("------>doLogin");
		return "login";
	}
}
