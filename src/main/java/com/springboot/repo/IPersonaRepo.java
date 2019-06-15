package com.springboot.repo;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.Persona;

//public interface IPersonaRepo extends JpaRepository<Persona, Integer> {
public interface IPersonaRepo extends CrudRepository<Persona, Integer> {

}
