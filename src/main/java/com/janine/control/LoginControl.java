package com.janine.control;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.janine.entity.SysUser;


@Controller
//@RequestMapping("/login")
public class LoginControl {
	
	private static Logger loger = Logger.getLogger(LoginControl.class);
	
    @RequestMapping(value = "/greeting/{user}", method = RequestMethod.GET)
    public String greeting(@PathVariable String user, Model model) {
        List<String> userList = Arrays.asList(user.split("-"));
        //userList is the variable name, used in ftl file.
        model.addAttribute("userList", userList);
        return "welcome";
    }

    
    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public ModelAndView greeting(@ModelAttribute("form") SysUser user,HttpServletRequest request) { 
    	System.out.println("======user=====>" + user.getUsername());
    	System.out.println("======user=====>" + user.getPassword());
    	loger.info("======user=====>" + user.getPassword());
    	
    	String kaptchaExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
    	System.out.println("=====code===>" + kaptchaExpected);
        List<String> userList = Arrays.asList(user.getUsername().split("-"));
        ModelAndView result = new ModelAndView("welcome");
        //userList is the variable name, used in ftl file.
        result.addObject("userList", userList);
        return result;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
