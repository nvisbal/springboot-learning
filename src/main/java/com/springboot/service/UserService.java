package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import com.springboot.model.Usuario;
import com.springboot.repo.IUsuarioRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//public interface IPersonaRepo extends JpaRepository<Persona, Integer> {
@Service
public class UserService implements UserDetailsService {

   @Autowired
   private IUsuarioRepo repositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repositorio.findByNombre(username);
        List<GrantedAuthority> authorites = new ArrayList<>();
        authorites.add(new SimpleGrantedAuthority("ADMIN"));

        UserDetails userDetails = new User(usuario.getNombre(), usuario.getClave(), authorites);
        return userDetails;
	}

}