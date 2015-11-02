package com.janine.control;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.janine.entity.User;

@Controller
//@RequestMapping("/login")
public class LoginControl {

    @RequestMapping(value = "/greeting/{user}", method = RequestMethod.GET)
    public String greeting(@PathVariable String user, Model model) {
        List<String> userList = Arrays.asList(user.split("-"));
        //userList is the variable name, used in ftl file.
        model.addAttribute("userList", userList);
        return "welcome";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public ModelAndView greeting(@RequestParam("username") String username,@ModelAttribute("user") User user) {
    	System.out.println("======user=====>" + username);
    	System.out.println("======user=====>" + user.getPassword());
        List<String> userList = Arrays.asList(username.split("-"));
        ModelAndView result = new ModelAndView("welcome");
        //userList is the variable name, used in ftl file.
        result.addObject("userList", userList);
        return result;
    }

    @RequestMapping("/login")
    public String login() {
    	 System.out.println("===================>");
        return "login";
    }
}
