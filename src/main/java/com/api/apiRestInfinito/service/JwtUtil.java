package com.api.apiRestInfinito.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class JwtUtil {
	private String secret="infinitoapp";//claveSecreta
	//private int jwtExpirationInMs=18000000;//tiempo de expiracion, en este caso pusimos 5 horas
	private int jwtExpirationInMs=0;
	private int refreshExpirationDateInMs=9000000;
	//generando el token para el usuario
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims=new HashMap<>();
		//primer obtenemos los roles
		Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
		if (roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {//si el rol es admin
			claims.put("esAdmin", true);//agregamos un clain al token
			
		}
		if (roles.contains(new SimpleGrantedAuthority("ROLE_USER"))) {//si el rol es admin
			claims.put("esUser", true);//agregamos un clain al token
			
		}
		//retornamos un metodo donde contruira el token
		return doGenerateToken(claims,userDetails.getUsername());
	}
	//MEtodo para crear el token, es llamado desde el metodo de arriba
	private String doGenerateToken(Map<String, Object> claims, String username) {
		
		return Jwts
				.builder()
				.setClaims(claims)//los claims, en este caso validaciones de los roles
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))//fecha creada
				.setExpiration(new Date(System.currentTimeMillis()+jwtExpirationInMs))//el tiempo de expiracion sera el que se creo  lo que definimos la duracion
				.signWith(SignatureAlgorithm.HS512, secret)//le pasamos la llave secreta
				.compact();
	}
	//Metodo para refrescar el token
	public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {

		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + refreshExpirationDateInMs))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();

	}
	
	//ahora crearemos un metodo para validar si el usuario que quiera ingresar a una ruta tiene un token y ademas este token esta logueado
	public boolean validateToken(String authToken) {
		try {
			// El token Jwt no ha sido manipulado
			Jws<Claims> claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);//obtenemos el token y obtenemos sus claims
			return true;
		} catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
			throw new BadCredentialsException("CREDENCIALES INVALIDAS",ex);
		} catch (ExpiredJwtException ex) {
			throw ex;
		}
	}
	//metodo para obtener el usuario del token
	public String getUsernameFromToken(String token) {
		Claims claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();//obtenemos primero el cuerpo del token ccon la llave secreta
		return claims.getSubject();//el sujeto sera el username, lo definimos en doGenerateToken() arriba
	}
	//obtenemos los roles del token
	public List<SimpleGrantedAuthority> getRolesFromToken(String token) {
		Claims claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();//obtenemos primero el cuerpo del token ccon la llave secreta
		List<SimpleGrantedAuthority> roles=null;
		
		Boolean isAdmin=claims.get("esAdmin",Boolean.class);		
		Boolean isUser=claims.get("esUser",Boolean.class);
		if (isAdmin!=null && isAdmin) {
			roles=Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		if (isUser!=null && isAdmin) {
			roles=Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return roles;
	}
}
