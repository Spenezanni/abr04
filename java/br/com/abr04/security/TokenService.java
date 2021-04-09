package br.com.abr04.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import br.com.abr04.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}") 
	private String secret;	

	public String gerarToken(Authentication authentication) {
		User logado = (User) authentication.getPrincipal();
		Date hoje =  new Date();
		Date dataExpiration = new Date(hoje.getTime() + expiration);
		return Jwts.builder()
				.setIssuer("API Security")
		        .setSubject(logado.getId().toString())
		        .setIssuedAt(hoje)
		        .setExpiration(dataExpiration)
		        .signWith(SignatureAlgorithm.HS256, secret)
		        .compact();
	}

}
	