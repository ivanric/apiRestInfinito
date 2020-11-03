package com.api.apiRestInfinito.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {

	@RequestMapping({"/hellouser"})
	public String getUser(){
		return "Hello User";
	}
	
	@RequestMapping({"/helloadmin"})
	public String getAdmin(){
		return "Hello Admin";
	}
}
