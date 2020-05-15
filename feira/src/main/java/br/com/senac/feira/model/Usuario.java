package br.com.senac.feira.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usuario_id;

	@Column(nullable = false)
	private String usuario_nome_completo;

	@Column(nullable = false)
	private String usuario_cpf;

	@Column(nullable = false)
	private int usuario_politica_lgpd;

	@Column(nullable = false)
	private int usuario_politica_lgpd_versao;

	@Column(nullable = false)
	private int usuario_status;

	@OneToMany(mappedBy = "usuario", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<SegmentoUsuario> segmentoUsuarios;

	@OneToMany(mappedBy = "usuario", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Curriculo> curriculos;

	@OneToMany(mappedBy = "usuario", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Candidatura> candidaturas;
	
	@OneToMany(mappedBy = "usuario", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<EventoUsuario> eventoUsuarios;

	public Usuario() {

	}

	public Usuario(Integer usuario_id, String usuario_nome_completo, String usuario_cpf, int usuario_politica_lgpd,
			int usuario_politica_lgpd_versao, int usuario_status, List<SegmentoUsuario> segmentoUsuarios,
			List<Curriculo> curriculos, List<Candidatura> candidaturas, List<EventoUsuario> eventoUsuarios) {
		super();
		this.usuario_id = usuario_id;
		this.usuario_nome_completo = usuario_nome_completo;
		this.usuario_cpf = usuario_cpf;
		this.usuario_politica_lgpd = usuario_politica_lgpd;
		this.usuario_politica_lgpd_versao = usuario_politica_lgpd_versao;
		this.usuario_status = usuario_status;
		this.segmentoUsuarios = segmentoUsuarios;
		this.curriculos = curriculos;
		this.candidaturas = candidaturas;
		this.eventoUsuarios = eventoUsuarios;
	}

	public Integer getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getUsuario_nome_completo() {
		return usuario_nome_completo;
	}

	public void setUsuario_nome_completo(String usuario_nome_completo) {
		this.usuario_nome_completo = usuario_nome_completo;
	}

	public String getUsuario_cpf() {
		return usuario_cpf;
	}

	public void setUsuario_cpf(String usuario_cpf) {
		this.usuario_cpf = usuario_cpf;
	}

	public int getUsuario_politica_lgpd() {
		return usuario_politica_lgpd;
	}

	public void setUsuario_politica_lgpd(int usuario_politica_lgpd) {
		this.usuario_politica_lgpd = usuario_politica_lgpd;
	}

	public int getUsuario_politica_lgpd_versao() {
		return usuario_politica_lgpd_versao;
	}

	public void setUsuario_politica_lgpd_versao(int usuario_politica_lgpd_versao) {
		this.usuario_politica_lgpd_versao = usuario_politica_lgpd_versao;
	}

	public int getUsuario_status() {
		return usuario_status;
	}

	public void setUsuario_status(int usuario_status) {
		this.usuario_status = usuario_status;
	}

	public List<SegmentoUsuario> getSegmentoUsuarios() {
		return segmentoUsuarios;
	}

	public void setSegmentoUsuarios(List<SegmentoUsuario> segmentoUsuarios) {
		this.segmentoUsuarios = segmentoUsuarios;
	}

	public List<Curriculo> getCurriculos() {
		return curriculos;
	}

	public void setCurriculos(List<Curriculo> curriculos) {
		this.curriculos = curriculos;
	}

	public List<Candidatura> getCandidaturas() {
		return candidaturas;
	}

	public void setCandidaturas(List<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}

	public List<EventoUsuario> getEventoUsuarios() {
		return eventoUsuarios;
	}

	public void setEventoUsuarios(List<EventoUsuario> eventoUsuarios) {
		this.eventoUsuarios = eventoUsuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}