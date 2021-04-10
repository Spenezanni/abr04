package br.com.abr04.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.abr04.model.User;
import br.com.abr04.repository.UserRepository;

public class AuthenticatinTokenFilter extends OncePerRequestFilter {
	

	private UserRepository userRepository;
	
	private TokenService tokenService;
	
	public AuthenticatinTokenFilter(TokenService tokenService, UserRepository userRepository) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperarToken(request);
		boolean tokenValido = tokenService.isTokenValid(token);
		if(tokenValido) {
			autenticarCliente(token);
		}
		System.out.println(tokenValido);
		System.out.println(token);
		filterChain.doFilter(request, response);	
	}

	private void autenticarCliente(String token) {
		Long idUser = tokenService.getIdUser(token);
		Optional<User> user = userRepository.findById(idUser);
		//User user = userRepository.findById(idUser).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.get().getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
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
