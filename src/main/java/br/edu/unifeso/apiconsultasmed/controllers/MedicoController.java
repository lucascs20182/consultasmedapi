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
import br.edu.unifeso.apiconsultasmed.models.MedicoModel;
import br.edu.unifeso.apiconsultasmed.services.MedicoService;

@RestController
@RequestMapping("/medico")
@CrossOrigin("*")
public class MedicoController {

	@Autowired
	MedicoService medicoService;
	
	@GetMapping
	public ResponseEntity<List<MedicoModel>> listarTodos() {
		return ResponseEntity.ok().body(medicoService.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicoModel> listarUm(@PathVariable String id) throws ItemNotFoundException {
		return ResponseEntity.ok().body(medicoService.listarUm(id));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<MedicoModel> cadastrar(@RequestBody MedicoModel medico) {
		return ResponseEntity.ok().body(medicoService.cadastrar(medico));
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable String id) throws ItemNotFoundException {
		medicoService.deletar(id);
		
		ResponseEntity.ok();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MedicoModel> atualizarDados(@PathVariable String id, @RequestBody MedicoModel medico) throws ItemNotFoundException {
		return ResponseEntity.ok().body(medicoService.atualizarDados(id, medico));
	}
}
