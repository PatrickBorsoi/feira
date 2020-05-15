package br.com.senac.feira.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "estados")
public class Estado implements Serializable {

	private static final long serialVersionUID = -83403215785378954L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer estado_id;

	private String estado_nome;

	private int estado_Status;

	@OneToMany(mappedBy = "estado", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Cidade> cidades;

	public Estado() {

	}

	public Estado(Integer estado_id, String estado_nome, int estado_Status, List<Cidade> cidades) {
		super();
		this.estado_id = estado_id;
		this.estado_nome = estado_nome;
		this.estado_Status = estado_Status;
		this.cidades = cidades;
	}

	public Integer getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(Integer estado_id) {
		this.estado_id = estado_id;
	}

	public String getEstado_nome() {
		return estado_nome;
	}

	public void setEstado_nome(String estado_nome) {
		this.estado_nome = estado_nome;
	}

	public int getEstado_Status() {
		return estado_Status;
	}

	public void setEstado_Status(int estado_Status) {
		this.estado_Status = estado_Status;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}