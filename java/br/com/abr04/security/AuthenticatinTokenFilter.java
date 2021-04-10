package br.com.abr04.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class AuthenticatinTokenFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperarToken(request);
		System.out.println(token);
		filterChain.doFilter(request, response);	
	}

	private String recuperarToken(HttpServletRequest request) {
		String tokenHeader = request.getHeader("Authorization");
		if(tokenHeader == null || tokenHeader.isEmpty() || !tokenHeader.startsWith("Bearer ")) {
			System.out.println("token invalido");
			return null;	
		}
		return tokenHeader.substring(7, tokenHeader.length());
	}

}
