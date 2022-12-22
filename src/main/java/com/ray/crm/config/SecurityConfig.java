package com.ray.crm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		User.UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("admin").password("password").roles("ADMIN"));
		auth.inMemoryAuthentication().withUser(users.username("user").password("password").roles("USER"));
		auth.inMemoryAuthentication().withUser(users.username("ray").password("password").roles("USER", "ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.anyRequest().authenticated() /// any request must be authenticated (check username & pass)
			.and()
			.formLogin()
				.loginPage("/showLoginPage")
				.loginProcessingUrl("/login")
				.permitAll() /// allow anonymous user to access login page
			.and()
				.logout().permitAll();
	}
}
