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
@Table(name = "segmento_usuarios")
public class SegmentoUsuario implements Serializable {

	private static final long serialVersionUID = -5331208460964354897L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer segmento_usuario_id;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "segmento_id", nullable = false)
	private Segmento segmento;

	public SegmentoUsuario() {

	}

	public SegmentoUsuario(Integer segmento_usuario_id, Usuario usuario, Segmento segmento) {
		super();
		this.segmento_usuario_id = segmento_usuario_id;
		this.usuario = usuario;
		this.segmento = segmento;
	}

	public Integer getSegmento_usuario_id() {
		return segmento_usuario_id;
	}

	public void setSegmento_usuario_id(Integer segmento_usuario_id) {
		this.segmento_usuario_id = segmento_usuario_id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Segmento getSegmento() {
		return segmento;
	}

	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}