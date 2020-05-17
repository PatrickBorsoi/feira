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
@Table(name = "responsavel")
public class Responsavel implements Serializable {

	private static final long serialVersionUID = -2794341436585057576L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer responsavel_id;

	private String responsavel_nome_completo;

	private boolean responsavel_status;

	private String responsavel_usuario;

	private String responsavel_senha;

	private String responsavel_email;

	private String responsavel_telefone;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	public Responsavel() {

	}

	public Responsavel(Integer responsavel_id, String responsavel_nome_completo, boolean responsavel_status, String responsavel_usuario, String responsavel_senha, String responsavel_email, String responsavel_telefone, Empresa empresa) {
		this.responsavel_id = responsavel_id;
		this.responsavel_nome_completo = responsavel_nome_completo;
		this.responsavel_status = responsavel_status;
		this.responsavel_usuario = responsavel_usuario;
		this.responsavel_senha = responsavel_senha;
		this.responsavel_email = responsavel_email;
		this.responsavel_telefone = responsavel_telefone;
		this.empresa = empresa;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getResponsavel_id() {
		return responsavel_id;
	}

	public void setResponsavel_id(Integer responsavel_id) {
		this.responsavel_id = responsavel_id;
	}

	public String getResponsavel_nome_completo() {
		return responsavel_nome_completo;
	}

	public void setResponsavel_nome_completo(String responsavel_nome_completo) {
		this.responsavel_nome_completo = responsavel_nome_completo;
	}

	public boolean getResponsavel_status() {
		return responsavel_status;
	}

	public void setResponsavel_status(boolean responsavel_status) {
		this.responsavel_status = responsavel_status;
	}

	public String getResponsavel_usuario() {
		return responsavel_usuario;
	}

	public void setResponsavel_usuario(String responsavel_usuario) {
		this.responsavel_usuario = responsavel_usuario;
	}

	public String getResponsavel_senha() {
		return responsavel_senha;
	}

	public void setResponsavel_senha(String responsavel_senha) {
		this.responsavel_senha = responsavel_senha;
	}

	public String getResponsavel_email() {
		return responsavel_email;
	}

	public void setResponsavel_email(String responsavel_email) {
		this.responsavel_email = responsavel_email;
	}

	public String getResponsavel_telefone() {
		return responsavel_telefone;
	}

	public void setResponsavel_telefone(String responsavel_telefone) {
		this.responsavel_telefone = responsavel_telefone;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}