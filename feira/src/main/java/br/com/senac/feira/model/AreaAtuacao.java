package br.com.senac.feira.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "area_atuacoes")
public class AreaAtuacao implements Serializable {

	private static final long serialVersionUID = -7149666479222629106L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer area_atuacao_id;

	private String area_atuacao_descricao;

	private int area_atuacao_status;

	public AreaAtuacao() {

	}

	public AreaAtuacao(Integer area_atuacao_id, String area_atuacao_descricao, int area_atuacao_status) {
		super();
		this.area_atuacao_id = area_atuacao_id;
		this.area_atuacao_descricao = area_atuacao_descricao;
		this.area_atuacao_status = area_atuacao_status;
	}

	public Integer getArea_atuacao_id() {
		return area_atuacao_id;
	}

	public void setArea_atuacao_id(Integer area_atuacao_id) {
		this.area_atuacao_id = area_atuacao_id;
	}

	public String getArea_atuacao_descricao() {
		return area_atuacao_descricao;
	}

	public void setArea_atuacao_descricao(String area_atuacao_descricao) {
		this.area_atuacao_descricao = area_atuacao_descricao;
	}

	public int getArea_atuacao_status() {
		return area_atuacao_status;
	}

	public void setArea_atuacao_status(int area_atuacao_status) {
		this.area_atuacao_status = area_atuacao_status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}