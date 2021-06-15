package br.edu.unifeso.apiconsultasmed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifeso.apiconsultasmed.exceptions.ItemNotFoundException;
import br.edu.unifeso.apiconsultasmed.models.PacienteModel;
import br.edu.unifeso.apiconsultasmed.services.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<List<PacienteModel>> listarTodos() {
		return ResponseEntity.ok().body(pacienteService.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PacienteModel> listarUm(@PathVariable String id) throws ItemNotFoundException {
		return ResponseEntity.ok().body(pacienteService.listarUm(id));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<PacienteModel> cadastrar(@RequestBody PacienteModel paciente) {
		return ResponseEntity.ok().body(pacienteService.cadastrar(paciente));
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable String id) throws ItemNotFoundException {
		pacienteService.deletar(id);
		
		ResponseEntity.ok();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PacienteModel> atualizarDados(@PathVariable String id, @RequestBody PacienteModel paciente) throws ItemNotFoundException {
		return ResponseEntity.ok().body(pacienteService.atualizarDados(id, paciente));
	}
}
