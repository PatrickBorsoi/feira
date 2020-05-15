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
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "eventos")
public class Evento implements Serializable {

	private static final long serialVersionUID = -5804018272266012520L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer evento_id;

	private String evento_titulo;

	private String evento_link_evento;

	private Date evento_data_hora;

	private String evento_link_banner;

	private int evento_vagas;

	private int evento_status;

	@ManyToOne
	@JoinColumn(name = "stand_id", nullable = false)
	private Stand stand;

	@ManyToOne
	@JoinColumn(name = "evento_tipo_id", nullable = false)
	private Stand eventoTipo;

	@OneToMany(mappedBy = "evento", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<EventoUsuario> eventoUsuarios;

	public Evento() {

	}

	public Evento(Integer evento_id, String evento_titulo, String evento_link_evento, Date evento_data_hora,
			String evento_link_banner, int evento_vagas, int evento_status, Stand stand, Stand eventoTipo,
			List<EventoUsuario> eventoUsuarios) {
		super();
		this.evento_id = evento_id;
		this.evento_titulo = evento_titulo;
		this.evento_link_evento = evento_link_evento;
		this.evento_data_hora = evento_data_hora;
		this.evento_link_banner = evento_link_banner;
		this.evento_vagas = evento_vagas;
		this.evento_status = evento_status;
		this.stand = stand;
		this.eventoTipo = eventoTipo;
		this.eventoUsuarios = eventoUsuarios;
	}

	public Integer getEvento_id() {
		return evento_id;
	}

	public void setEvento_id(Integer evento_id) {
		this.evento_id = evento_id;
	}

	public String getEvento_titulo() {
		return evento_titulo;
	}

	public void setEvento_titulo(String evento_titulo) {
		this.evento_titulo = evento_titulo;
	}

	public String getEvento_link_evento() {
		return evento_link_evento;
	}

	public void setEvento_link_evento(String evento_link_evento) {
		this.evento_link_evento = evento_link_evento;
	}

	public Date getEvento_data_hora() {
		return evento_data_hora;
	}

	public void setEvento_data_hora(Date evento_data_hora) {
		this.evento_data_hora = evento_data_hora;
	}

	public String getEvento_link_banner() {
		return evento_link_banner;
	}

	public void setEvento_link_banner(String evento_link_banner) {
		this.evento_link_banner = evento_link_banner;
	}

	public int getEvento_vagas() {
		return evento_vagas;
	}

	public void setEvento_vagas(int evento_vagas) {
		this.evento_vagas = evento_vagas;
	}

	public int getEvento_status() {
		return evento_status;
	}

	public void setEvento_status(int evento_status) {
		this.evento_status = evento_status;
	}

	public Stand getStand() {
		return stand;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}

	public Stand getEventoTipo() {
		return eventoTipo;
	}

	public void setEventoTipo(Stand eventoTipo) {
		this.eventoTipo = eventoTipo;
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