package br.edu.unifeso.apiconsultasmed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifeso.apiconsultasmed.exceptions.ItemNotFoundException;
import br.edu.unifeso.apiconsultasmed.models.ConsultaModel;
import br.edu.unifeso.apiconsultasmed.services.ConsultaService;
import br.edu.unifeso.apiconsultasmed.services.MedicoService;
import br.edu.unifeso.apiconsultasmed.services.PacienteService;

@RestController
@RequestMapping("/consulta")
@CrossOrigin("*")
public class ConsultaController {

	@Autowired
	PacienteService pacienteService;
	
	@Autowired
	MedicoService medicoService;
	
	@Autowired
	ConsultaService consultaService;
	
	@GetMapping
	public ResponseEntity<List<ConsultaModel>> listarTodos() {
		return ResponseEntity.ok().body(consultaService.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsultaModel> listarUm(@PathVariable String id) throws ItemNotFoundException {
		return ResponseEntity.ok().body(consultaService.listarUm(id));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<ConsultaModel> cadastrar(@RequestBody ConsultaModel consulta) throws ItemNotFoundException {
			return ResponseEntity.ok().body(consultaService.cadastrar(consulta, pacienteService, medicoService));
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable String id) throws ItemNotFoundException {
		consultaService.deletar(id);
		
		ResponseEntity.ok();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ConsultaModel> atualizarDados(@PathVariable String id, @RequestBody ConsultaModel consulta) throws ItemNotFoundException {
		return ResponseEntity.ok().body(consultaService.atualizarDados(id, consulta));
	}
}
