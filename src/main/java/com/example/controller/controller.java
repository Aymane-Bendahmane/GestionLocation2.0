package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dao.UserRepository;
import com.example.entities.Bien;
import com.example.entities.User;

@Controller
public class controller {

	@Autowired
	private UserRepository userimp;

	@GetMapping(path = "/index")
	String getIndex() {
		return "index";
	}

	/*********** login ***********/
	@GetMapping(path = "/login")
	String getregister() {

		return "login";
	}

	/*********** Register user ***********/
	@GetMapping(path = "/User_register")
	String getregister(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping(path = "/User_Ajouter")
	String register_user(@ModelAttribute User user) {
	PasswordEncoder passwordEncoder = passwordEncoder();
	user.setPassword(passwordEncoder.encode(user.getPassword()));
		userimp.save(user);
		return "blank";
	}

	@GetMapping(path = "/User_Afficher")
	String User_Afficher(Model model) {
		List<User> lUSer = userimp.findAll();
		model.addAttribute("users" , lUSer);
		return "AfficherUsers";
	}

	
	
	/*********** Register Bien ***********/
	@GetMapping(path = "/Ajouter_Bien")
	String Ajouter_Bien(Model model) {
		model.addAttribute("bien", new Bien());
		return "AjouterBien";
	}
	
	/*********************************************/
	
	
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

}
