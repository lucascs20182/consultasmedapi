package br.edu.unifeso.apiconsultasmed.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Consulta")
public class ConsultaModel {

	@Id
	private String id;
	
	private String idPaciente;
	private String idMedico;
	private String dataConsulta;

	private String representacaoPaciente;
	private String representacaoMedico;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getRepresentacaoPaciente() {
		return representacaoPaciente;
	}

	public void setRepresentacaoPaciente(String representacaoPaciente) {
		this.representacaoPaciente = representacaoPaciente;
	}

	public String getRepresentacaoMedico() {
		return representacaoMedico;
	}

	public void setRepresentacaoMedico(String representacaoMedico) {
		this.representacaoMedico = representacaoMedico;
	}
}
