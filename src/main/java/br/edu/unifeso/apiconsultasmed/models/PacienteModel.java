package br.edu.unifeso.apiconsultasmed.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Paciente")
public final class PacienteModel extends Pessoa {
	
}
