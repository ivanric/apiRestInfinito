package com.api.apiRestInfinito.component;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

///esta la clase sera para devolver las peticiones 401,usuarios que no estan autentificados
//Esta clase se utiliza para devolver un error 401 no autorizado a los clientes que intentan 
//acceder a un recurso protegido sin la autenticación adecuada.
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{
	//Implementa la interfaz Spring Security AuthenticationEntryPoint. En esta clase crearemos 
		//la HttpResponse que debe devolverse al usuario en caso de una excepción.

		@Override
		public void commence(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException authException) throws IOException, ServletException {
			
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//si el estado es 401
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);//el contenido sera de tipo json cuando para la respuesta 401
			
			String message;
			
			
			// Verifica si la solicitud es alguna excepción que hayamos almacenado en Solicitud
			final Exception exception=(Exception)request.getAttribute("exception");	
			// Si es así, utilícelo para crear el mensaje de respuesta; de lo contrario, use la excepción authException
			if (exception!=null) {// si se ha encontrado esa propiedad y es diferente de null
				/*
				//aqui es cuando expira el token o el tiempo es 0
				if (exception.getCause()!=null) {//si la causa de la exexcion es diferente de nullo, es que hay una error en la auth
					message=exception.getCause().toString()+" "+exception.getMessage();
				}else {//si no hay errores
					message=exception.getMessage();
				}
				
				//le pasamos la causa del error, y se manda como json ,,en caso de acceder a otra ruta ejemplo /helloadmin, sin un token
				byte [] body =new ObjectMapper().writeValueAsBytes(Collections.singletonMap("error", message));
				//Collections.singletonMap("error",message);
				
				response.getOutputStream().write(body);
				*/
				byte[] body = new ObjectMapper().writeValueAsBytes(Collections.singletonMap("cause", exception.toString()));

				response.getOutputStream().write(body);
				
			}else {
				if (authException.getCause()!=null) {//si la causa de la exexcion es diferente de nullo, es que hay una error en la auth
					message=authException.getCause().toString()+" "+authException.getMessage();
					System.out.println("errorCausa1:"+authException.getMessage());
				}else {//si no hay errores
					message=authException.getMessage();
					System.out.println("errorCausa2:"+authException.getCause());
					System.out.println("errorCausa2Code:"+authException.hashCode());
				}
				
				//le pasamos la causa del error, y se manda como json ,,en caso de acceder a otra ruta ejemplo /helloadmin, sin un token
				byte [] body =new ObjectMapper().writeValueAsBytes(Collections.singletonMap("error", message));
				//Collections.singletonMap("error",message);
				
				response.getOutputStream().write(body);
			}
			
			

		}

}
