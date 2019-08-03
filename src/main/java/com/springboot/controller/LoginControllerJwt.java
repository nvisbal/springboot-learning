package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/login")

public class LoginControllerJwt {

	@GetMapping
	public void login(
		@RequestParam("user") String username,
		@RequestParam("password") String password
	) { 
		
	}

	// private String getJWTToken(String username) {
	// 	String secretKey = "mySecretKey";
	// 	List grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
	// 	String token = Jwts
	// 			.builder()
	// 			.setId("softtekJWT")
	// 			.setSubject(username)
	// 			.claim("authorities",
	// 					grantedAuthorities.stream()
	// 							.map(GrantedAuthority::getAuthority)
	// 							.collect(Collectors.toList()))
	// 			.setIssuedAt(new Date(System.currentTimeMillis()))
	// 			.setExpiration(new Date(System.currentTimeMillis() + 600000))
	// 			.signWith(SignatureAlgorithm.HS512,
	// 					secretKey.getBytes()).compact();

	// 	return "Bearer " + token;
	// }
}
