package br.edu.unifeso.apiconsultasmed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.exceptions.ItemNotFoundException;
import br.edu.unifeso.apiconsultasmed.models.PacienteModel;
import br.edu.unifeso.apiconsultasmed.repositories.PacienteRepository;

@Service
public final class PacienteService {
	@Autowired
	PacienteRepository pacienteRepository;

	public List<PacienteModel> listarTodos() {
		return pacienteRepository.findAll();
	}

	public PacienteModel listarUm(String id) throws ItemNotFoundException {
		if(pacienteRepository.findById(id).isEmpty()) {
			throw new ItemNotFoundException("Paciente com id " + id + " não encontrado");
		}
		
		return pacienteRepository.findById(id).get();
	}
	
	public PacienteModel cadastrar(PacienteModel paciente) {
		return pacienteRepository.save(paciente);
	}

	public void deletar(String id) throws ItemNotFoundException {
		if(pacienteRepository.findById(id).isEmpty()) {
			throw new ItemNotFoundException("Paciente com id " + id + " não encontrado");
		}
		
		pacienteRepository.deleteById(id);
	}

	public PacienteModel atualizarDados(String id, PacienteModel novosDados) throws ItemNotFoundException {
		PacienteModel paciente = listarUm(id);
		
		paciente.setNome(novosDados.getNome());
		paciente.setSobrenome(novosDados.getSobrenome());
		paciente.setCpf(novosDados.getCpf());
		paciente.setDataNascimento(novosDados.getDataNascimento());
		
		return pacienteRepository.save(paciente);
	}
}
