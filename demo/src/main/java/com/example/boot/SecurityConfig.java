package com.example.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//패스워드 인코딩
	@Bean	//<bean id="" class="">
	public PasswordEncoder bcryptPassword() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
							.antMatchers("/home","/").permitAll()
							.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
							.anyRequest().authenticated())
	
		.formLogin(login -> login
				.loginPage("/login")			//따로 로그인페이지를 설정해준다.
				.usernameParameter("userid")	//html input name을 따로 설정해준다.
				.defaultSuccessUrl("/home")
				.permitAll()
				)
	
		.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/home")
				.permitAll();
				/*.and()
				
		.csrf().disable();*/
		
		return http.build();
	}
	
	/*@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("1234")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}*/
}
