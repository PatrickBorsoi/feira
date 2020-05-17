package br.com.senac.feira.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bairro")
public class Bairro implements Serializable {

	private static final long serialVersionUID = -1014886601423434925L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bairro_id;

	private String bairro_nome;

	private int bairro_status;

	@ManyToOne
	@JoinColumn(name = "cidade_id", nullable = false)
	private Cidade cidade;

	public Bairro() {

	}

	public Bairro(Integer bairro_id, String bairro_nome, int bairro_status, Cidade cidade) {
		super();
		this.bairro_id = bairro_id;
		this.bairro_nome = bairro_nome;
		this.bairro_status = bairro_status;
		this.cidade = cidade;
	}

	public Integer getBairro_id() {
		return bairro_id;
	}

	public void setBairro_id(Integer bairro_id) {
		this.bairro_id = bairro_id;
	}

	public String getBairro_nome() {
		return bairro_nome;
	}

	public void setBairro_nome(String bairro_nome) {
		this.bairro_nome = bairro_nome;
	}

	public int getBairro_status() {
		return bairro_status;
	}

	public void setBairro_status(int bairro_status) {
		this.bairro_status = bairro_status;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}