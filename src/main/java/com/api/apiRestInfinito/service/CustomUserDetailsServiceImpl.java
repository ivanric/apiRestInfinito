package com.api.apiRestInfinito.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.ILoginDAO;
import com.api.apiRestInfinito.dao.IRolDAO;
import com.api.apiRestInfinito.dao.IUsuarioDAO;
import com.api.apiRestInfinito.model.Rol;
import com.api.apiRestInfinito.model.Usuario;


@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	ILoginDAO iLoginDAO;
	@Autowired
	IRolDAO iRolDAO;
	@Autowired
	IUsuarioDAO iUsuarioDAO;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;//para encriptar contraseñas de usuarios al registrar
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user;
		String usuario,contrasenia;
		List<Rol> ListaRoles;
		try {
			user=this.iLoginDAO.getUserByMail(username);//aqui cambia, cuenta de username sera email
			//Clase Optional 
			//Optional<Usuario> usuarioOptional=Optional.of(user);//Se crea un usuario de tipo optional es decir q si es nul optionalUser recibe el valor vacio  caso contrario se almacena el Usuario
			usuario=user.getMail();
			contrasenia=user.getPassword();
			ListaRoles=this.iRolDAO.AllRoleByUsername(user.getMail());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		//return usuarioOptional.map(AQUI RECIBE UNA CLASE).get();
		return this.userBuild(usuario, contrasenia, ListaRoles);
	}
	
	private User userBuild(String username,String password,List<Rol> roles) {//User implementacion de UserDeatils
		//boolean enabled=true;
		//boolean accountNonExpired=true;
		//boolean credentialsNonExpired=true;
		//boolean accountNonLocked=true;
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		for (Rol rol : roles) {//https://juejin.im/entry/6844903551190171655
           System.out.println("Role:"+rol.getNombre());
			authorities.add(new SimpleGrantedAuthority("ROLE_"+rol.getNombre().toUpperCase()));
		}
		return new User(username, password, authorities);
		
		//return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);	
	}
	
	//guardamos en la base de datos al usuario
	public boolean save(Usuario user,int idemp) {
		//Usuario newUser = new Usuario();
		//newUser.setUsername(user.getUsername());
		//newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return iUsuarioDAO.saveUsuario(user,idemp);//save es generico del java para el repositorio
	}
	
	
	//metodo adionado
	public List<Rol> getRolesByMail(String mail){
		List<Rol> ListaRoles=null;
		try {
			ListaRoles=this.iRolDAO.AllRoleByUsername(mail);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return ListaRoles;
	}
	
}
