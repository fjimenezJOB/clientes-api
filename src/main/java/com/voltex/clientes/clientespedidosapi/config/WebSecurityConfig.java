package com.voltex.clientes.clientespedidosapi.config;

import com.voltex.clientes.clientespedidosapi.security.JWTAuthorizationFilter;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin();
		http.csrf().disable().addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().antMatchers(HttpMethod.GET, 
						"/", 
						"/v2/api-docs", // swagger
						"/webjars/**", // swagger-ui webjars
						"/swagger-resources/**", // swagger-ui resources
						"/configuration/**", // swagger configuration
						"/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js",
						"/user/getAutentication",
						"/user/createUser",
						"/h2-ui/***",
						"/h2_console/**")
				.permitAll()
				.antMatchers(HttpMethod.GET, "/user", "user/*","/user/createUser", "/h2-ui/***").permitAll()
				.antMatchers(HttpMethod.POST, "/user/getAutentication", "/user/createUser").permitAll()
				.antMatchers("/h2-ui/**").permitAll().anyRequest()
				.authenticated();
				http.headers().frameOptions().disable();
;

	}
}