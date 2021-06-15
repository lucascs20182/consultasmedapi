package br.edu.unifeso.apiconsultasmed.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.models.ClienteModel;
import br.edu.unifeso.apiconsultasmed.repositories.ClienteRepository;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	ClienteRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<ClienteModel> cliente = repository.findByUsername(username);
		if (cliente.isEmpty()) {
			System.out.println("Usuario não existe");
			return null;
		}
		return new UserSS(cliente.get().getId(), cliente.get().getUsername(), cliente.get().getSenha());
	}

}