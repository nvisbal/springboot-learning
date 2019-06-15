package com.springboot.repo;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.Usuario;

//public interface IPersonaRepo extends JpaRepository<Persona, Integer> {
public interface IUsuarioRepo extends CrudRepository<Usuario, Integer> {

}
