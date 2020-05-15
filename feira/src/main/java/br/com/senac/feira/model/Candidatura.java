package br.com.senac.feira.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "candidaturas")
public class Candidatura implements Serializable {

	private static final long serialVersionUID = 2935938753163746317L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candidatura_id;

	@ManyToOne
	@JoinColumn(name = "vaga_id", nullable = false)
	private Vaga vaga;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "curriculo_id", nullable = false)
	private Curriculo curriculo;

	@OneToOne
	@JoinColumn(name = "etapa_processo_id", nullable = false)
	private EtapaProcesso etapaProcesso;

	public Candidatura() {

	}

	public Candidatura(Integer candidatura_id, Vaga vaga, Usuario usuario, Curriculo curriculo,
			EtapaProcesso etapaProcesso) {
		super();
		this.candidatura_id = candidatura_id;
		this.vaga = vaga;
		this.usuario = usuario;
		this.curriculo = curriculo;
		this.etapaProcesso = etapaProcesso;
	}

	public Integer getCandidatura_id() {
		return candidatura_id;
	}

	public void setCandidatura_id(Integer candidatura_id) {
		this.candidatura_id = candidatura_id;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public EtapaProcesso getEtapaProcesso() {
		return etapaProcesso;
	}

	public void setEtapaProcesso(EtapaProcesso etapaProcesso) {
		this.etapaProcesso = etapaProcesso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}