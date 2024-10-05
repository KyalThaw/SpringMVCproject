package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.repo.BookRepository;

import com.spring.model.BookBean;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookRepository bookRepo;
	
	@GetMapping(value="/showbook")
	public String showAllBooks(Model m) {
		
		 bookRepo = new BookRepository();
	    List<BookBean> list =  bookRepo.showAllBook();
	    if (list.size()>0) {
	      
	      m.addAttribute("list",list);
	      
	    } else {
	    	
	    	m.addAttribute("error","No book available");
	    	
	    }
	    return "booklist";
		
	}
	
	@GetMapping(value="/editbook/{id}")
	public String selectBookById(@PathVariable("id")int id,Model m) {
		
		
		BookBean obj = bookRepo.showBookById(id);
		m.addAttribute("obj",obj);
		return "editbook";
		
	}

}
