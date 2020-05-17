package br.com.senac.feira.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etapa_processo")
public class EtapaProcesso implements Serializable {

	private static final long serialVersionUID = -7867138759861781253L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer etapa_processo_id;

	private String etapa_processo_descricao;

	private int etapa_processo_Status;

	public EtapaProcesso() {

	}

	public EtapaProcesso(Integer etapa_processo_id, String etapa_processo_descricao, int etapa_processo_Status) {
		super();
		this.etapa_processo_id = etapa_processo_id;
		this.etapa_processo_descricao = etapa_processo_descricao;
		this.etapa_processo_Status = etapa_processo_Status;
	}

	public Integer getEtapa_processo_id() {
		return etapa_processo_id;
	}

	public void setEtapa_processo_id(Integer etapa_processo_id) {
		this.etapa_processo_id = etapa_processo_id;
	}

	public String getEtapa_processo_descricao() {
		return etapa_processo_descricao;
	}

	public void setEtapa_processo_descricao(String etapa_processo_descricao) {
		this.etapa_processo_descricao = etapa_processo_descricao;
	}

	public int getEtapa_processo_Status() {
		return etapa_processo_Status;
	}

	public void setEtapa_processo_Status(int etapa_processo_Status) {
		this.etapa_processo_Status = etapa_processo_Status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}