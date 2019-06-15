package com.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.model.Persona;
import com.springboot.repo.IPersonaRepo;

@Controller
public class DemoController {

	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping("/greeting")
	public String greeting(			
			@RequestParam(name="name", required=false, defaultValue="Wordl") String name, 
			@RequestParam(name="lastname", required=false, defaultValue="Visbal") String lastname,
			Model model) {
		
		Persona p = new Persona();
		
		p.setName("Nelson Visbal");
		repo.save(p);
		
		model.addAttribute("name", name);
		model.addAttribute("lastname", lastname);
		return "greeting";
	}
	
	@GetMapping("/list")
	public String list(Model model) {	
		model.addAttribute("list", repo.findAll());
		
		model.addAttribute("person", repo.findById(5).orElse(new Persona("Hey")));
//		repo.findById(5).ifPresent(p -> {
//			logger.info("La persona encontrada fue " + p.getName());
//		});
//		System.out.println("Nombre " + p.getName());

		
		return "greeting";
	}
	
}
