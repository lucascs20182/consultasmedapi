package br.edu.unifeso.apiconsultasmed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.exceptions.ItemNotFoundException;
import br.edu.unifeso.apiconsultasmed.models.ConsultaModel;
import br.edu.unifeso.apiconsultasmed.models.MedicoModel;
import br.edu.unifeso.apiconsultasmed.models.PacienteModel;
import br.edu.unifeso.apiconsultasmed.repositories.ConsultaRepository;

@Service
public class ConsultaService {
	@Autowired
	ConsultaRepository consultaRepository;

	public List<ConsultaModel> listarTodos() {
		return consultaRepository.findAll();
	}

	public ConsultaModel listarUm(String id) throws ItemNotFoundException {
		if(consultaRepository.findById(id).isEmpty()) {
			throw new ItemNotFoundException("Consulta com id " + id + " não encontrado");
		}
		
		return consultaRepository.findById(id).get();
	}
	
	public ConsultaModel cadastrar(ConsultaModel consulta, PacienteService pacienteService, 
			MedicoService medicoService) throws ItemNotFoundException {
				
				PacienteModel paciente = pacienteService.listarUm(consulta.getIdPaciente());
				MedicoModel medico = medicoService.listarUm(consulta.getIdMedico());

				consulta.setRepresentacaoPaciente(String.format("%s - CPF %s", paciente.getNome(), paciente.getCpf()));
				consulta.setRepresentacaoMedico(String.format("%s - CRM %s", medico.getNome(), medico.getCrm()));		
				
				return consultaRepository.save(consulta);
	}

	public void deletar(String id) throws ItemNotFoundException {
		if(consultaRepository.findById(id).isEmpty()) {
			throw new ItemNotFoundException("Consulta com id " + id + " não encontrado");
		}
		
		consultaRepository.deleteById(id);
	}

	public ConsultaModel atualizarDados(String id, ConsultaModel novosDados) throws ItemNotFoundException {
		ConsultaModel consulta = listarUm(id);
		
		consulta.setDataConsulta(novosDados.getDataConsulta());
		
		return consultaRepository.save(consulta);
	}
}
