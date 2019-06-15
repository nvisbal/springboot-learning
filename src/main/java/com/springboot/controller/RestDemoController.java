package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Persona;
import com.springboot.repo.IPersonaRepo;

@RestController
@RequestMapping("/api/v1/personas")
public class RestDemoController {

	@Autowired
	IPersonaRepo repositorio;
	
	@GetMapping
	public List<Persona> listar() { 
		return (List<Persona>) repositorio.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Persona get(@PathVariable("id") Integer id) { 
		return (Persona) repositorio.findById(id).get();
	}
	
	@PostMapping
	public void insert (@RequestBody Persona person) {
		repositorio.save(person);	
	}
	
	@PutMapping
	public void update (@RequestBody Persona person) {
		repositorio.save(person);	
	}
	
	@DeleteMapping(value="/{id}")
	public void insert (@PathVariable("id") Integer id) {
		repositorio.deleteById(id);	
	}
}
