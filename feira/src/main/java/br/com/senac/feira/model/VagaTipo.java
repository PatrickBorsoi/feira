package br.com.senac.feira.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaga_tipos")
public class VagaTipo implements Serializable {

	private static final long serialVersionUID = -6214980825927249106L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vaga_tipo_id;

	private String vaga_tipo_descricao;

	private int vaga_tipo_status;

	public VagaTipo() {

	}

	public VagaTipo(Integer vaga_tipo_id, String vaga_tipo_descricao, int vaga_tipo_status) {
		super();
		this.vaga_tipo_id = vaga_tipo_id;
		this.vaga_tipo_descricao = vaga_tipo_descricao;
		this.vaga_tipo_status = vaga_tipo_status;
	}

	public Integer getVaga_tipo_id() {
		return vaga_tipo_id;
	}

	public void setVaga_tipo_id(Integer vaga_tipo_id) {
		this.vaga_tipo_id = vaga_tipo_id;
	}

	public String getVaga_tipo_descricao() {
		return vaga_tipo_descricao;
	}

	public void setVaga_tipo_descricao(String vaga_tipo_descricao) {
		this.vaga_tipo_descricao = vaga_tipo_descricao;
	}

	public int getVaga_tipo_status() {
		return vaga_tipo_status;
	}

	public void setVaga_tipo_status(int vaga_tipo_status) {
		this.vaga_tipo_status = vaga_tipo_status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}