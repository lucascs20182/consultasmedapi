package br.edu.unifeso.apiconsultasmed.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.unifeso.apiconsultasmed.models.ConsultaModel;

public interface ConsultaRepository extends MongoRepository<ConsultaModel, String> {

}
