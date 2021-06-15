package br.edu.unifeso.apiconsultasmed.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.unifeso.apiconsultasmed.models.MedicoModel;

public interface MedicoRepository extends MongoRepository<MedicoModel, String> {

}
