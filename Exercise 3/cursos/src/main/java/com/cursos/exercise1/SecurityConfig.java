package com.cursos.exercise1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager usersDetails() throws Exception {
		List<UserDetails> users = new ArrayList<>();

		Map<String, String[]> userRoles = new HashMap<>();
		userRoles.put("user1", new String[]{"INVITADO"});
		userRoles.put("user2", new String[]{"OPERADOR"});
		userRoles.put("user3", new String[]{"ADMIN"});
		userRoles.put("user4", new String[]{"OPERADOR", "ADMIN"});

		for (Map.Entry<String, String[]> entry : userRoles.entrySet()) {
			users.add(User.withUsername(entry.getKey())
					.password("{noop}" + entry.getKey())
					.roles(entry.getValue())
					.build());
		}

		return new InMemoryUserDetailsManager(users);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(cr -> cr.disable())
				.authorizeHttpRequests(aut ->
						aut.requestMatchers(HttpMethod.POST, "curso").hasAnyRole("ADMIN")
								.requestMatchers(HttpMethod.DELETE, "/curso/**").hasAnyRole("ADMIN", "OPERADOR")
								.requestMatchers(HttpMethod.PUT, "/curso/**").hasAnyRole("ADMIN", "OPERADOR")
								.requestMatchers("cursos", "/curso/**").authenticated()
								.anyRequest().permitAll())
				.httpBasic(Customizer.withDefaults());
		return http.build();
	}

}
