package com.example.demo.securing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	//암호화 한거 bean 등록하기! 
	public BCryptPasswordEncoder bryptEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll() //requestMAthcers에서 ant 로 바꿔졌음 version 떄문에, permitAll 
				.antMatchers("/admin/**").hasAnyRole("ADMIN","SUPER")
				.anyRequest().authenticated() //로그인해야지
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.usernameParameter("userid") //login.html에서 input name username 인거 변경하고나서 이렇게
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());
			//.userDetailsService();

		return http.build();
	}
	

	//@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("1234")
				.roles("ADMIN") // 접근권한
				.build();
		
		return new InMemoryUserDetailsManager(user);
	}

}
