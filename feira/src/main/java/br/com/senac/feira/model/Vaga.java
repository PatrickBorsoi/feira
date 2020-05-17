package br.com.senac.feira.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "vaga")
public class Vaga implements Serializable {

	private static final long serialVersionUID = 7990505509176791810L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vaga_id;

	private int vaga_senac;

	private String vaga_codigo_senac;

	private String vaga_url_vaga;

	private String vaga_cargo;

	private String vaga_descricao;

	private int vaga_quantidade;

	private double vaga_remuneracao;

	private String vaga_requisitos;

	private String vaga_atividades_principais;

	private String vaga_beneficios;

	private String vaga_observacoes;

	private Date vaga_disponibilidade_inicio;

	private Date vaga_disponibilidade_fim;

	private String vaga_status;

	@OneToOne
	@JoinColumn(name = "area_atuacao_id", nullable = false)
	private AreaAtuacao areaAtuacao;

	@OneToOne
	@JoinColumn(name = "bairro_id", nullable = false)
	private Bairro bairro;

	@OneToOne
	@JoinColumn(name = "cidade_id", nullable = false)
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "empresa_id", nullable = false)
	private Empresa empresa;

	@OneToOne
	@JoinColumn(name = "estado_id", nullable = false)
	private Estado estado;

	@OneToOne
	@JoinColumn(name = "segmento_id", nullable = false)
	private Segmento segmento;

	@OneToOne
	@JoinColumn(name = "vaga_tipo_id", nullable = false)
	private VagaTipo vagaTipo;

	@OneToMany(mappedBy = "vaga", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Candidatura> candidaturas;

	public Vaga() {

	}

	public Vaga(Integer vaga_id, int vaga_senac, String vaga_codigo_senac, String vaga_url_vaga, String vaga_cargo, String vaga_descricao, int vaga_quantidade, double vaga_remuneracao, String vaga_requisitos, String vaga_atividades_principais, String vaga_beneficios, String vaga_observacoes, Date vaga_disponibilidade_inicio, Date vaga_disponibilidade_fim, String vaga_status, AreaAtuacao areaAtuacao, Bairro bairro, Cidade cidade, Empresa empresa, Estado estado, Segmento segmento, VagaTipo vagaTipo, List<Candidatura> candidaturas) {
		this.vaga_id = vaga_id;
		this.vaga_senac = vaga_senac;
		this.vaga_codigo_senac = vaga_codigo_senac;
		this.vaga_url_vaga = vaga_url_vaga;
		this.vaga_cargo = vaga_cargo;
		this.vaga_descricao = vaga_descricao;
		this.vaga_quantidade = vaga_quantidade;
		this.vaga_remuneracao = vaga_remuneracao;
		this.vaga_requisitos = vaga_requisitos;
		this.vaga_atividades_principais = vaga_atividades_principais;
		this.vaga_beneficios = vaga_beneficios;
		this.vaga_observacoes = vaga_observacoes;
		this.vaga_disponibilidade_inicio = vaga_disponibilidade_inicio;
		this.vaga_disponibilidade_fim = vaga_disponibilidade_fim;
		this.vaga_status = vaga_status;
		this.areaAtuacao = areaAtuacao;
		this.bairro = bairro;
		this.cidade = cidade;
		this.empresa = empresa;
		this.estado = estado;
		this.segmento = segmento;
		this.vagaTipo = vagaTipo;
		this.candidaturas = candidaturas;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getVaga_id() {
		return vaga_id;
	}

	public void setVaga_id(Integer vaga_id) {
		this.vaga_id = vaga_id;
	}

	public int getVaga_senac() {
		return vaga_senac;
	}

	public void setVaga_senac(int vaga_senac) {
		this.vaga_senac = vaga_senac;
	}

	public String getVaga_codigo_senac() {
		return vaga_codigo_senac;
	}

	public void setVaga_codigo_senac(String vaga_codigo_senac) {
		this.vaga_codigo_senac = vaga_codigo_senac;
	}

	public String getVaga_url_vaga() {
		return vaga_url_vaga;
	}

	public void setVaga_url_vaga(String vaga_url_vaga) {
		this.vaga_url_vaga = vaga_url_vaga;
	}

	public String getVaga_cargo() {
		return vaga_cargo;
	}

	public void setVaga_cargo(String vaga_cargo) {
		this.vaga_cargo = vaga_cargo;
	}

	public String getVaga_descricao() {
		return vaga_descricao;
	}

	public void setVaga_descricao(String vaga_descricao) {
		this.vaga_descricao = vaga_descricao;
	}

	public int getVaga_quantidade() {
		return vaga_quantidade;
	}

	public void setVaga_quantidade(int vaga_quantidade) {
		this.vaga_quantidade = vaga_quantidade;
	}

	public double getVaga_remuneracao() {
		return vaga_remuneracao;
	}

	public void setVaga_remuneracao(double vaga_remuneracao) {
		this.vaga_remuneracao = vaga_remuneracao;
	}

	public String getVaga_requisitos() {
		return vaga_requisitos;
	}

	public void setVaga_requisitos(String vaga_requisitos) {
		this.vaga_requisitos = vaga_requisitos;
	}

	public String getVaga_atividades_principais() {
		return vaga_atividades_principais;
	}

	public void setVaga_atividades_principais(String vaga_atividades_principais) {
		this.vaga_atividades_principais = vaga_atividades_principais;
	}

	public String getVaga_beneficios() {
		return vaga_beneficios;
	}

	public void setVaga_beneficios(String vaga_beneficios) {
		this.vaga_beneficios = vaga_beneficios;
	}

	public String getVaga_observacoes() {
		return vaga_observacoes;
	}

	public void setVaga_observacoes(String vaga_observacoes) {
		this.vaga_observacoes = vaga_observacoes;
	}

	public Date getVaga_disponibilidade_inicio() {
		return vaga_disponibilidade_inicio;
	}

	public void setVaga_disponibilidade_inicio(Date vaga_disponibilidade_inicio) {
		this.vaga_disponibilidade_inicio = vaga_disponibilidade_inicio;
	}

	public Date getVaga_disponibilidade_fim() {
		return vaga_disponibilidade_fim;
	}

	public void setVaga_disponibilidade_fim(Date vaga_disponibilidade_fim) {
		this.vaga_disponibilidade_fim = vaga_disponibilidade_fim;
	}

	public String getVaga_status() {
		return vaga_status;
	}

	public void setVaga_status(String vaga_status) {
		this.vaga_status = vaga_status;
	}

	public AreaAtuacao getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(AreaAtuacao areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Segmento getSegmento() {
		return segmento;
	}

	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}

	public VagaTipo getVagaTipo() {
		return vagaTipo;
	}

	public void setVagaTipo(VagaTipo vagaTipo) {
		this.vagaTipo = vagaTipo;
	}

	public List<Candidatura> getCandidaturas() {
		return candidaturas;
	}

	public void setCandidaturas(List<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}
}