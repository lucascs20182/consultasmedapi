package br.edu.unifeso.apiconsultasmed.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.unifeso.apiconsultasmed.models.PacienteModel;

public interface PacienteRepository extends MongoRepository<PacienteModel, String> {

}
