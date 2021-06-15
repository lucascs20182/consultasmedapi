package br.edu.unifeso.apiconsultasmed.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Medico")
public final class MedicoModel extends Pessoa {

	private String especialidade;

	private String crm;

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
}
