package com.springboot;

import com.springboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private UserService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}


	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
	// 	auth
	// 	  .inMemoryAuthentication()
	// 	  .withUser("user")
	// 	   .password("$2a$10$X1J7dvnvtHORxp/dwYRzwudpXY6VLpq0xOvlmzWf1U12zUhN6p/ay")
	// 	   .roles("USER")
	// 	   .and()
	// 	  .withUser("admin")
	// 	   .password("admin")
	// 	   .roles("USER", "ADMIN");
	// }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		  .authorizeRequests()
		  .anyRequest()
		  .authenticated()
		  .and()
		  .httpBasic();
	}

}
