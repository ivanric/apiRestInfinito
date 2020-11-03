package com.api.apiRestInfinito.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.apiRestInfinito.model.AuthenticationRequest;
import com.api.apiRestInfinito.model.AuthenticationResponse;
import com.api.apiRestInfinito.model.Persona;
import com.api.apiRestInfinito.model.RegistrarRequest;
import com.api.apiRestInfinito.model.Rol;
import com.api.apiRestInfinito.model.Usuario;
import com.api.apiRestInfinito.service.CustomUserDetailsServiceImpl;
import com.api.apiRestInfinito.service.IPersonaService;
import com.api.apiRestInfinito.service.IUsuarioService;
import com.api.apiRestInfinito.service.IloginService;
import com.api.apiRestInfinito.service.JwtUtil;


import io.jsonwebtoken.impl.DefaultClaims;

@RestController
public class RestAuthentication {

	//instanciamos el AuthenticationManager  que se usa en el  SecurityConfiguration
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//instanciamos la modificacion del userDetailsService donde se indica los roles y admins
	@Autowired
	CustomUserDetailsServiceImpl userDetailsService;
	
	//instanciamos el jstUtil donde se crea el token etc
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private IPersonaService personaService;

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IloginService loginService;	
	//redefinimos el metodo de  autehntificacion, recibira un parametro como json @RequestBody 
	@CrossOrigin("http://localhost:8090")
	@RequestMapping(value = "/authenticate",method = RequestMethod.POST)
	public ResponseEntity<?> crearAutentificacionToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {//authenticationRequest es un modelo para la autentificacion
		Map<String, Object> authData;
		AuthenticationResponse autenticado=new AuthenticationResponse();
		String token="";
		List<Rol> roles=null;
		
		try {
			authenticationManager.authenticate(//se usara una autentificacion por token, le pasamos el usuario y password q vendra de postman
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), 
							authenticationRequest.getPassword()));
				
			
			//respuesta del token
			UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			token=jwtUtil.generateToken(userDetails);//le pasamos el userDetails donde esta los permisos, y lo guardamos en una cadena
			autenticado.setToken(token);
			autenticado.setMail(authenticationRequest.getUsername().trim());
			
			//le pasamos el usuario que se a logueado para pasarle roles, y validamos de acuerdo a sus roles
			authData=this.loginService.getDataLogin(authenticationRequest.getUsername());
			if (authData!=null) {
				String idUser=String.valueOf(authData.get("idusu"));
				if(!idUser.equals("") || !idUser.isEmpty() || idUser!=null) {
					System.out.println("iduser:"+idUser);
					autenticado.setIdusu(Integer.parseInt(idUser));
				}
				if (authData.get("username")==null) {
					autenticado.setUsername("");
				}else {
					autenticado.setUsername(String.valueOf(authData.get("username")));	
				}
				if (authData.get("foto")==null) {
					autenticado.setFotoUrl("");
				}else {
					autenticado.setFotoUrl(String.valueOf(authData.get("foto")));
				}
				if (authData.get("estado")==null) {
					autenticado.setActivo(false);
				}else {
					String estadoS=String.valueOf(authData.get("estado"));
					if(!estadoS.equals("") || !estadoS.isEmpty() || estadoS!=null) {
						System.out.println("estado:"+estadoS);
						int estInt=Integer.parseInt(estadoS);
						if (estInt==1) {
							autenticado.setActivo(true);	
						}else {
							autenticado.setActivo(false);
						}
					}
				}
				autenticado.setCreado(String.valueOf(authData.get("creado")));
			}
			//roles
			roles=this.userDetailsService.getRolesByMail(authenticationRequest.getUsername());
			if (roles!=null) {
				autenticado.setRoles(roles);
			}
			
		} catch (DisabledException e) {
			throw new Exception("Usuario desabilitado",e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Credenciales no validas",e);
				
		}
		

		
		return new ResponseEntity<AuthenticationResponse>(autenticado, HttpStatus.OK); //instanciamos el modelo donde devolvera el token
	
	}//despues configurar el SecurityConfiguration para agregar este metodo
	
	
	/*
	 * En AuthenticationController, expondremos una API POST para tomar la solicitud de registro del usuario 
	 * y llamar al método de guardado que definimos en el Servicio CustomUserDetails*/
	@CrossOrigin("http://localhost:8090")
	@Transactional
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(HttpServletRequest req,@RequestBody RegistrarRequest registrarRequest) throws Exception {
		Map<String,Object> resp=new HashMap<String, Object>();
		/*
		if (persona!=null) {
			System.out.println("persona_param:"+persona.toString());
			
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			String tipoUser=req.getParameter("tipoUser");
			
			System.err.println("username:"+username);
			System.err.println("password:"+password);
			System.err.println("tipoUser:"+tipoUser);
			persona.getUsuario().setUsername(username);
			persona.getUsuario().setPassword(password);
			persona.getUsuario().setTipo(tipoUser);
			System.out.println("persona_param_mod:"+persona.toString());
			
		}*/
		try {
			if (registrarRequest!=null) {
				System.out.println("registrarRequest:"+registrarRequest.toString());
				Persona persona=registrarRequest.getPersona();
				if (persona!=null) {
					System.out.println("persona_param:"+persona.toString());
					Usuario usuarioExiste = usuarioService.findUserByEmail(persona.getUsuario().getMail());
					if (usuarioExiste == null) {//Incorrect result size: expected 1, actual 0, cuando no esta registrado el usuario, entra a este metodo
						Map<String,Object> respC=personaService.savePersona(persona);
						if ((boolean)respC.get("status")) {
							//aqui le pasamos el idper al usuario
							int idper=(Integer)respC.get("idper");
							System.out.println("idper:"+idper);
							persona.getUsuario().setIdper(idper);
							System.out.println("User_mod:"+persona.getUsuario().toString());
							
							int idemp=0;
							if (registrarRequest.getIdemp()!=null) {
								idemp=registrarRequest.getIdemp();
							}
							
							if (userDetailsService.save(persona.getUsuario(),idemp)) {
								resp.put("error",false);
								resp.put("message","usuario creado correctamente");
								resp.put("contenido","");
							}
						} else {
							resp.put("error",true);
							resp.put("message","Error al guardar los datos de persona");
							resp.put("contenido","");
						}
					}else {
						resp.put("error",true);
						resp.put("message","Este usuario ya se encuentra registrado");
						resp.put("contenido","");
					}
				}
				
			}
		
	
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//si hay un error en algun priceso se controla la transaccion
			resp.put("error",true);
			resp.put("message","ocurrio un error, intenta nuevamente");
			resp.put("contenido","");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return ResponseEntity.ok(resp);
		//return ResponseEntity.ok("");
	}
	
	
	//Controlador para refrescar el token
	@RequestMapping(value = "/refreshtoken", method = RequestMethod.GET)
	@CrossOrigin("http://localhost:8090")
	public ResponseEntity<?> refreshtoken(HttpServletRequest request) throws Exception {
		// Desde HttpRequest obtenemos los claims -> From the HttpRequest get the claims
		DefaultClaims claims = (io.jsonwebtoken.impl.DefaultClaims) request.getAttribute("claims"); // request.getAttribute("claims") desde el filtro

		Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
		//aqui refrescamos el token con los claims que estan en  expectedMap
		String token = jwtUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
		
		AuthenticationResponse autenticado=new AuthenticationResponse();
		autenticado.setToken(token);
		return ResponseEntity.ok(autenticado);
	}
	
	//metodo que carga los claims en un mapa para obtener y ponerlo en un nuevo token
	public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
		Map<String, Object> expectedMap = new HashMap<String, Object>();
		for (Entry<String, Object> entry : claims.entrySet()) {
			expectedMap.put(entry.getKey(), entry.getValue());
		}
		return expectedMap;
	}
}
