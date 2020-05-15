package br.com.senac.feira.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evento_usuarios")
public class EventoUsuario implements Serializable {

	private static final long serialVersionUID = -2241381715227914723L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer evento_usuario_id;

	private Date evento_usuario_data_registro;
	
	private String evento_usuario_link_certificado;
	
	private int evento_usuario_status;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "evento_id", nullable = false)
	private Evento evento;

	public EventoUsuario() {

	}

	public EventoUsuario(Integer evento_usuario_id, Date evento_usuario_data_registro,
			String evento_usuario_link_certificado, int evento_usuario_status, Usuario usuario, Evento evento) {
		super();
		this.evento_usuario_id = evento_usuario_id;
		this.evento_usuario_data_registro = evento_usuario_data_registro;
		this.evento_usuario_link_certificado = evento_usuario_link_certificado;
		this.evento_usuario_status = evento_usuario_status;
		this.usuario = usuario;
		this.evento = evento;
	}

	public Integer getEvento_usuario_id() {
		return evento_usuario_id;
	}

	public void setEvento_usuario_id(Integer evento_usuario_id) {
		this.evento_usuario_id = evento_usuario_id;
	}

	public Date getEvento_usuario_data_registro() {
		return evento_usuario_data_registro;
	}

	public void setEvento_usuario_data_registro(Date evento_usuario_data_registro) {
		this.evento_usuario_data_registro = evento_usuario_data_registro;
	}

	public String getEvento_usuario_link_certificado() {
		return evento_usuario_link_certificado;
	}

	public void setEvento_usuario_link_certificado(String evento_usuario_link_certificado) {
		this.evento_usuario_link_certificado = evento_usuario_link_certificado;
	}

	public int getEvento_usuario_status() {
		return evento_usuario_status;
	}

	public void setEvento_usuario_status(int evento_usuario_status) {
		this.evento_usuario_status = evento_usuario_status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}