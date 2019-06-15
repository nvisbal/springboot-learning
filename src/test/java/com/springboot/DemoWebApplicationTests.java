package com.springboot;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.model.Usuario;
import com.springboot.repo.IUsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoWebApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder bcpw;
	
	@Test
	public void crearUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setId(4);
		usuario.setNombre("usuario 4");
		usuario.setClave(bcpw.encode("123"));
		Usuario retorno = repo.save(usuario);
		
		assertTrue(retorno.getNombre().equalsIgnoreCase(usuario.getNombre()));
		assertTrue(retorno.getClave().equalsIgnoreCase(usuario.getClave()));
	}

}
