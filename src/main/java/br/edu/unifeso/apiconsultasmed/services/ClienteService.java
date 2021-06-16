package br.edu.unifeso.apiconsultasmed.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.exceptions.ItemAlreadyExistsException;
import br.edu.unifeso.apiconsultasmed.models.ClienteModel;
import br.edu.unifeso.apiconsultasmed.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;

	@Autowired
	BCryptPasswordEncoder bCrypt;

	public List<ClienteModel> getAll() {
		return repository.findAll();
	}

	public ClienteModel getById(String id) {
		Optional<ClienteModel> opt = repository.findById(id);

		return opt.get();
	}

	public ClienteModel create(ClienteModel entity) throws ItemAlreadyExistsException {

		for (ClienteModel cliente : this.getAll()) {

			if (cliente.getEmail().equals(entity.getEmail())) {
				throw new ItemAlreadyExistsException("Uma conta já foi cadastrada utilizando este e-mail.");
			}

			if (cliente.getUsername().equals(entity.getUsername())) {
				throw new ItemAlreadyExistsException("Uma conta já foi cadastrada utilizando este username.");
			}
		}

		entity.setSenha(bCrypt.encode(entity.getSenha()));

		return repository.save(entity);
	}
}
