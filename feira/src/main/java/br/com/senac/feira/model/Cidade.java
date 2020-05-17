package br.com.senac.feira.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

	private static final long serialVersionUID = -3726967027122501480L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cidade_id;

	private String cidade_nome;

	private int cidade_status;

	@ManyToOne
	@JoinColumn(name = "estado_estado_id", nullable = false)
	private Estado estado;

	@OneToMany(mappedBy = "cidade", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Bairro> bairros;

	public Cidade() {

	}

	public Cidade(Integer cidade_id, String cidade_nome, int cidade_status, Estado estado, List<Bairro> bairros) {
		super();
		this.cidade_id = cidade_id;
		this.cidade_nome = cidade_nome;
		this.cidade_status = cidade_status;
		this.estado = estado;
		this.bairros = bairros;
	}

	public Integer getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(Integer cidade_id) {
		this.cidade_id = cidade_id;
	}

	public String getCidade_nome() {
		return cidade_nome;
	}

	public void setCidade_nome(String cidade_nome) {
		this.cidade_nome = cidade_nome;
	}

	public int getCidade_status() {
		return cidade_status;
	}

	public void setCidade_status(int cidade_status) {
		this.cidade_status = cidade_status;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}