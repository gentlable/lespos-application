package jp.co.fullhouse.lespos.lesposapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // @formatter:off
		http
			.authorizeHttpRequests(authz -> authz
				.requestMatchers("/login","/webjars/**").permitAll()
				.anyRequest().authenticated()
			)
			.csrf(c -> c
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			)
			.oauth2Login()
		;
			
		http
    	.logout()
		;
		// @formatter:on
    return http.build();

  }

}
