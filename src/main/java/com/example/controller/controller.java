package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.dao.UserRepository;
import com.example.entities.User;

@Controller
public class controller {

	@Autowired
	   private UserRepository userimp;
	   /***********Sign in ***********/
	    @GetMapping(path = "/signin")
	    String getSignin(Model model){
	        model.addAttribute("user",new User());
	        return "signin" ;
	    }
	 
	    /***********Sign up ***********/
	    @GetMapping(path = "/signup")
	    String getSignup(Model model){
	        model.addAttribute("signup_user",new User());
	        return "signup" ;
	    }
	    @PostMapping(path = "/register_user")
	    String register_user(@ModelAttribute User user) {
	    	userimp.save(user);
	    	return "success";
	    }
	    @GetMapping(path = "/deconnexion")
	    String deconnexion( HttpSession session) {
	    	session.setAttribute("userlogin",null);
	    	return "redirect:signin" ;
	    }
	    /********************Bien access*******************/
	    @GetMapping(path = "/biens")
	    String getBiens(Model model) {
	    	
	    	return "biens";
	    }
	    /********************Dashbborad****************/
	    @GetMapping(path = "DashBoard")
	    String getDash() {
	    	
	    	return "DashBoard" ;
	    }
}
