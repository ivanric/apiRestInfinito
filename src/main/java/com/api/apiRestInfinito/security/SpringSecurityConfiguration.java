package com.api.apiRestInfinito.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.apiRestInfinito.component.JwtAuthenticationEntryPoint;
import com.api.apiRestInfinito.filter.CustomJwtAuthenticationFilter;
import com.api.apiRestInfinito.service.CustomUserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	//metodo donde se cargara los roles
	@Autowired
	CustomUserDetailsServiceImpl userDetailsService;
	
	//Filtro de autentication por jwt, 
	@Autowired
	private  CustomJwtAuthenticationFilter customJwtAuthenticationFilter;
	
	@Autowired//manejo de errores,401, un usuario no registrado
  	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {//COMO CONFIGURAR A LOS USUARIOS

		//auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());	//userDetailsService viene de CustomUserDetailsServiceImpl.java
	}
	
	
	//esto sobreescribimos  la configuracion para la  utentificacion por token
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()//se desabilito el csrf
		.authorizeRequests()
			.antMatchers("/RestEmpresa/*").permitAll()//autificarse con token para este caso
			.antMatchers("/RestSolicitudes/*").permitAll()
			.antMatchers("/helloadmin").hasRole("ADMIN")
			.antMatchers("/hellouser").hasAnyRole("USER","ADMIN")
			.antMatchers("/authenticate","/register").permitAll().anyRequest().authenticated()//autificarse con token para este caso
			//.and().httpBasic();//lo comentamos por que ahora autentificaremos con jwt
			
			.and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)//si el error es 401, no encontrado
			// asegúrese de que usamos una sesión sin estado; la sesión no se utilizará para
			// almacenar el estado del usuario.
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		
		// Agregamos un filtro para validar los tokens con cada solicitud en la peticion http
			.and().addFilterBefore(customJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
			//.cors()
			;
		
		
	}
}
