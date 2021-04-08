package br.com.abr04.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.abr04.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@PostMapping
	@RequestMapping
	public ResponseEntity<?> authenticationLogin(@RequestBody LoginForm form){
		System.out.println(form.getLogin());
		return ResponseEntity.ok().build();
	}

}
