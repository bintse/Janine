package com.janine.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginControl {

	@RequestMapping("/validate")
	public String userloginValidate(){
		System.out.println("------:");
		return "";
	}
}
