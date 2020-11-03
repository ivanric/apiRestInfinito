package com.api.apiRestInfinito.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.apiRestInfinito.service.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
@Component
public class CustomJwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;//para entrar a los metodos del token
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//ahora lo que jharemos es capturar cada error para informarle que le token ha expiradp, para eso try cachc
		
		try {
			// JWT Token tiene el formato "Bearer token". Eliminar la palabra portadora y obtén solo el Token
			String jwtToken=extractJwtFromRequest(request);//metodo para extraer el token de una peticion
			if (StringUtils.hasText(jwtToken) && jwtUtil.validateToken(jwtToken)) {//si se valida el token, y ahi esta logueado
				
				UserDetails userDetails=new User(jwtUtil.getUsernameFromToken(jwtToken), "", 
						jwtUtil.getRolesFromToken(jwtToken));//creamos un user donde le pasamos las credenciales
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
						new UsernamePasswordAuthenticationToken(userDetails, "", jwtUtil.getRolesFromToken(jwtToken));
				// Después de configurar la Autenticación en el contexto, especificamos
				// que el usuario actual está autenticado. Entonces pasa el
				// Configuraciones de seguridad de Spring con éxito.
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}else {
				System.err.println("No se puede establecer el contexto de seguridad");
			}
			
		// despues de capturar modificar en JwtAuthenticationEntryPoint	
		} catch (ExpiredJwtException ex) {//si el token ha expirado
			//request.setAttribute("exception", ex);
			//request.setAttribute("exception", "el token ha expirado");no puedo pasar una cadena sale error 500
			
			//SI EL TOKEN HA EXPIRADO
			String isRefreshToken = request.getHeader("isRefreshToken");//si tiene el atributo en su encabezado de refresh token
			String requestURL = request.getRequestURL().toString();
			//  Permitir la creación de Refresh Token si se cumplen las siguientes condiciones. -> allow for Refresh Token creation if following conditions are true.
			if (isRefreshToken != null && isRefreshToken.equals("true") && requestURL.contains("refreshtoken")) {
				// le indicamos que este usuario esta autentificado y pasa la session de seguridad y pasa a /refreshtoken
				allowForRefreshToken(ex, request);
			} else
				System.out.println("ecepcion enviar:\n"+ex);
				request.setAttribute("exception", ex);//si ha expirado el token manda la excepcion
			
			
		} catch (BadCredentialsException ex) {//si las credenciales de auth no son validas
			request.setAttribute("exception", ex);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		filterChain.doFilter(request, response);//aqui permite ingresar a una ruta ej /helloadmin o /refreshtoken despemde a la peticion
	}
	
	private void allowForRefreshToken(ExpiredJwtException ex, HttpServletRequest request) {

		// crea un UsernamePasswordAuthenticationToken con valores nulos. -> create a UsernamePasswordAuthenticationToken with null values.
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				null, null, null);
		
		// Después de establecer la autenticación en el contexto, especificamos
		// que el usuario actual está autenticado. Así que pasa el
		// Configuraciones de seguridad de Spring con éxito.
		
		// After setting the Authentication in the context, we specify
		// that the current user is authenticated. So it passes the
		// Spring Security Configurations successfully.
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		// Set the claims so that in controller we will be using it to create
		// new JWT
		request.setAttribute("claims", ex.getClaims());

	}
	
	private String extractJwtFromRequest(HttpServletRequest request) {
		String bearerToken=request.getHeader("Authorization");
		System.out.println("El token extraer:"+bearerToken);
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {//si el token inicia en bearer
			return bearerToken.substring(7,bearerToken.length());//7 es desde ->"Bearer ", hsata el final sacamos el token
		}
		return null;
	}
	
}
