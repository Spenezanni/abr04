package br.com.abr04.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.abr04.model.User;
import br.com.abr04.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<User> loginAuth = userRepository.findByLogin(login);
		if(loginAuth.isPresent()) {
			System.out.println("Logado");
			return loginAuth.get();		
		}
	    throw new UsernameNotFoundException("User não encontrado!");
	}

}
