package fiap.br.challenge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fiap.br.challenge.domain.Cliente;
import fiap.br.challenge.repository.ClienteRepository;

@Service
public class ClienteService implements UserDetailsService {
	
	@Autowired
	ClienteRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Cliente> usuario = repo.findByUsername(username);
		if (usuario.isPresent()) {
			var userObj = usuario.get();
			System.out.println(userObj.getSenha());

			return User.builder().username(userObj.getEmail()).password(userObj.getSenha()).build();
		} else {
			throw new UsernameNotFoundException(username);
		}
	}

}
