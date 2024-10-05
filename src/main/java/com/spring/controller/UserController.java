package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.UserBean;
import com.spring.repo.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping(value="/Register")
	public ModelAndView showRegister() {
		
		return new ModelAndView("Register","userObj",new UserBean());
		
	}
	
	@PostMapping(value="/insert")
	public String doRegister(@ModelAttribute("userObj")UserBean user,BindingResult be, Model m) {
		
		int i = repo.insertUser(user);
        
        if (i>0) {
          return "redirect:/";
        }else {
     
          m.addAttribute("error","Inseert Fail!");
          return "Register";   
        }
		
		
	}

}
