package br.edu.unifeso.apiconsultasmed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.exceptions.ItemNotFoundException;
import br.edu.unifeso.apiconsultasmed.models.MedicoModel;
import br.edu.unifeso.apiconsultasmed.repositories.MedicoRepository;

@Service
public class MedicoService {
	@Autowired
	MedicoRepository medicoRepository;

	public List<MedicoModel> listarTodos() {
		return medicoRepository.findAll();
	}

	public MedicoModel listarUm(String id) throws ItemNotFoundException {
		if(medicoRepository.findById(id).isEmpty()) {
			throw new ItemNotFoundException("Médico com id " + id + " não encontrado");
		}
		
		return medicoRepository.findById(id).get();
	}
	
	public MedicoModel cadastrar(MedicoModel medico) {
		return medicoRepository.save(medico);
	}

	public void deletar(String id) throws ItemNotFoundException {
		if(medicoRepository.findById(id).isEmpty()) {
			throw new ItemNotFoundException("Médico com id " + id + " não encontrado");
		}
		
		medicoRepository.deleteById(id);
	}

	public MedicoModel atualizarDados(String id, MedicoModel novosDados) throws ItemNotFoundException {
		MedicoModel medico = listarUm(id);
		
		medico.setNome(novosDados.getNome());
		medico.setSobrenome(novosDados.getSobrenome());
		medico.setCpf(novosDados.getCpf());
		medico.setDataNascimento(novosDados.getDataNascimento());
		medico.setEspecialidade(novosDados.getEspecialidade());
		medico.setCrm(novosDados.getCrm());

		return medicoRepository.save(medico);
	}
}
