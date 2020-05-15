package br.com.senac.feira.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "stands")
public class Stand implements Serializable{

	private static final long serialVersionUID = 628073798127632644L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stand_id;
	
	private String stand_nome;
	
	private String stand_link_apresentacao;
	
	private String stand_link_chat;
	
	private int stand_status;
	
	private String stand_link_logomarca;
	
	@OneToOne
	@JoinColumn(name = "empresa_id", nullable = false)
	private Empresa empresa;
	
	@OneToMany(mappedBy = "stand", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Evento> eventos;
	
	public Stand() {
		
	}

	public Stand(Integer stand_id, String stand_nome, String stand_link_apresentacao, String stand_link_chat,
			int stand_status, String stand_link_logomarca, Empresa empresa, List<Evento> eventos) {
		super();
		this.stand_id = stand_id;
		this.stand_nome = stand_nome;
		this.stand_link_apresentacao = stand_link_apresentacao;
		this.stand_link_chat = stand_link_chat;
		this.stand_status = stand_status;
		this.stand_link_logomarca = stand_link_logomarca;
		this.empresa = empresa;
		this.eventos = eventos;
	}

	public Integer getStand_id() {
		return stand_id;
	}

	public void setStand_id(Integer stand_id) {
		this.stand_id = stand_id;
	}

	public String getStand_nome() {
		return stand_nome;
	}

	public void setStand_nome(String stand_nome) {
		this.stand_nome = stand_nome;
	}

	public String getStand_link_apresentacao() {
		return stand_link_apresentacao;
	}

	public void setStand_link_apresentacao(String stand_link_apresentacao) {
		this.stand_link_apresentacao = stand_link_apresentacao;
	}

	public String getStand_link_chat() {
		return stand_link_chat;
	}

	public void setStand_link_chat(String stand_link_chat) {
		this.stand_link_chat = stand_link_chat;
	}

	public int getStand_status() {
		return stand_status;
	}

	public void setStand_status(int stand_status) {
		this.stand_status = stand_status;
	}

	public String getStand_link_logomarca() {
		return stand_link_logomarca;
	}

	public void setStand_link_logomarca(String stand_link_logomarca) {
		this.stand_link_logomarca = stand_link_logomarca;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}