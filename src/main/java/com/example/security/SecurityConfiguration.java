package com.example.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = passwordEncoder();

		System.out.println(passwordEncoder.encode("1234"));
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"SELECT login as principal , password as credentials,active from user where login=?")
				.authoritiesByUsernameQuery("SELECT login as principal , role as role from user where login=?")
				.passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http.formLogin().loginPage("/login").permitAll();
		//http.formLogin();
		http.csrf().disable(); 
		// http.csrf().disable(); pour désactiver la protection
		
		//http.authorizeRequests().antMatchers("/static**/**").permitAll();
		http.authorizeRequests().anyRequest().permitAll();
		http.exceptionHandling().accessDeniedPage("/notauthorized"); // custom error page

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

}
