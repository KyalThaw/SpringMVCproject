package com.spring.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.PhotoBean;
import com.spring.repo.PhotoRepo;

@Controller
public class ImageController {
	
	
	
	
	  @GetMapping(value="/photo")
	  public ModelAndView showPhoto() {
	  
	  PhotoBean bean = new PhotoBean(); return new
	  ModelAndView("photo","photoObj",bean); }
	  
	  @PostMapping("AddPhoto")
	  public String photoAdd(@ModelAttribute("photoObj")@Validated PhotoBean obj, BindingResult
	  br, Model m) throws IOException,SQLException { byte[] imageobj;
	  PhotoRepo repo = new PhotoRepo(); imageobj = obj.getPhoto().getBytes(); 
	  int i =repo.insertUser(imageobj); 
	  if(i>0){ System.out.println("Insert Successful");
	  } else { System.out.println("Insert Fail"); }
	  
	  PhotoBean imageObj = repo.viewPhoto(obj); m.addAttribute("obj",imageObj);
	  
	  
	  return "viewphoto";
	  
	  }
	 

}
