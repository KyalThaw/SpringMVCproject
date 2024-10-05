package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.UserBean;

@Controller
public class TestController {
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public String showTest() {
		return "redirect:index";
	}
	
	@GetMapping(value ="/index")
	public String showIndex(Model m) {
		m.addAttribute("msg","Spring MVC");
		return "index";
		
	}
	@GetMapping("/showform")
	public ModelAndView showUser() {
		UserBean obj = new UserBean();
		
		ModelAndView mv= new ModelAndView("user","userObj",obj);
		return mv;
	}
	@PostMapping(value="/adduser")
	public String addUser( Model m,@Validated @ModelAttribute("userObj")UserBean obj,BindingResult br) {
		
		if(br.hasErrors()) {
			return "user";
		}
		
		m.addAttribute("user",obj);
		return "userview";
	}
	
	@ModelAttribute("lst")
	public List<String> addFrameworks(){
		List<String> frameworks = new ArrayList<String>();
		frameworks.add("Spring");
		frameworks.add("JAP");
		frameworks.add("Hibernate");
		
		return frameworks;
		
	}
	
	@ModelAttribute("numList")
	public List<Integer> addNumbers(){
		List<Integer> number = new ArrayList<Integer>();
		number.add(1);
		number.add(2);
		number.add(3);
		
		return number;
	}
	
	@ModelAttribute("list")
	public Map<String,String> countryList(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("US", "United States");
		map.put("JP", "Japan");
		map.put("SG", "Singapore");
		return map;
	}
	
}

