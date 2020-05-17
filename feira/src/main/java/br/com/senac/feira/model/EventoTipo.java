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
@Table(name = "evento_tipo")
public class EventoTipo implements Serializable {

	private static final long serialVersionUID = 1113766295348354427L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer evento_tipo_id;

	private String evento_tipo_descricao;

	private int evento_tipo_status;

	@OneToMany(mappedBy = "eventoTipo", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Evento> eventos;

	public EventoTipo() {

	}

	public EventoTipo(Integer evento_tipo_id, String evento_tipo_descricao, int evento_tipo_status,
			List<Evento> eventos) {
		super();
		this.evento_tipo_id = evento_tipo_id;
		this.evento_tipo_descricao = evento_tipo_descricao;
		this.evento_tipo_status = evento_tipo_status;
		this.eventos = eventos;
	}

	public Integer getEvento_tipo_id() {
		return evento_tipo_id;
	}

	public void setEvento_tipo_id(Integer evento_tipo_id) {
		this.evento_tipo_id = evento_tipo_id;
	}

	public String getEvento_tipo_descricao() {
		return evento_tipo_descricao;
	}

	public void setEvento_tipo_descricao(String evento_tipo_descricao) {
		this.evento_tipo_descricao = evento_tipo_descricao;
	}

	public int getEvento_tipo_status() {
		return evento_tipo_status;
	}

	public void setEvento_tipo_status(int evento_tipo_status) {
		this.evento_tipo_status = evento_tipo_status;
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