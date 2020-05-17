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
import org.hibernate.annotations.Type;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = -1954672581118611077L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empresa_id;

	private String empresa_nome;

	private String empresa_cnpj;
	@Type(type="text")
	private String empresa_descricao;

	@OneToMany(mappedBy = "empresa", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Vaga> vagas;

	@OneToMany(mappedBy = "empresa", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Responsavel> responsaveis;

	public Empresa() {

	}

	public Empresa(Integer empresa_id, String empresa_nome, String empresa_cnpj, String empresa_descricao,
			List<Vaga> vagas, List<Responsavel> responsaveis) {
		super();
		this.empresa_id = empresa_id;
		this.empresa_nome = empresa_nome;
		this.empresa_cnpj = empresa_cnpj;
		this.empresa_descricao = empresa_descricao;
		this.vagas = vagas;
		this.responsaveis = responsaveis;
	}

	public Integer getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(Integer empresa_id) {
		this.empresa_id = empresa_id;
	}

	public String getEmpresa_nome() {
		return empresa_nome;
	}

	public void setEmpresa_nome(String empresa_nome) {
		this.empresa_nome = empresa_nome;
	}

	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}

	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}

	public String getEmpresa_descricao() {
		return empresa_descricao;
	}

	public void setEmpresa_descricao(String empresa_descricao) {
		this.empresa_descricao = empresa_descricao;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}