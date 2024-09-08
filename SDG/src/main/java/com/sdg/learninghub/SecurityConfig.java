package com.sdg.learninghub;

import com.sdg.learninghub.member.MemberRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//private final MemberSecurityService memberSecurityService;
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
					.requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
					.anyRequest().authenticated()
		);
		http
			.formLogin((auth) -> auth
					.loginPage("/user/login")
					.defaultSuccessUrl("/user/login_success")
					.failureUrl("/user/access_denied")
					.usernameParameter("email") 
					.permitAll()
		);
		/**http
			.oauth2Login((login) -> login
					.defaultSuccessUrl("/user/login-success")
					.failureUrl("/user/access_denied")
					.permitAll()
					//.userService(customOAuth2UserService)
		);*/
		http
			.logout((logout) -> logout
					.logoutSuccessUrl("/home")
					.invalidateHttpSession(true)
		);
			
		return http.build();
	} 
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    /**public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberSecurityService).passwordEncoder(new BCryptPasswordEncoder());
    }*/
}
