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
@Table(name = "curriculos")
public class Curriculo implements Serializable {

	private static final long serialVersionUID = -6046951357110742454L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer curriculo_id;

	private String curriculo_nome;

	private int curriculo_status;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	public Curriculo() {

	}

	public Curriculo(Integer curriculo_id, String curriculo_nome, int curriculo_status, Usuario usuario) {
		super();
		this.curriculo_id = curriculo_id;
		this.curriculo_nome = curriculo_nome;
		this.curriculo_status = curriculo_status;
		this.usuario = usuario;
	}

	public Integer getCurriculo_id() {
		return curriculo_id;
	}

	public void setCurriculo_id(Integer curriculo_id) {
		this.curriculo_id = curriculo_id;
	}

	public String getCurriculo_nome() {
		return curriculo_nome;
	}

	public void setCurriculo_nome(String curriculo_nome) {
		this.curriculo_nome = curriculo_nome;
	}

	public int getCurriculo_status() {
		return curriculo_status;
	}

	public void setCurriculo_status(int curriculo_status) {
		this.curriculo_status = curriculo_status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}