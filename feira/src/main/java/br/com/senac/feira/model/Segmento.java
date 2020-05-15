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
@Table(name = "segmentos")
public class Segmento implements Serializable {

	private static final long serialVersionUID = 1516769406405097492L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer segmento_id;

	private String segmento_descricao;

	private int segmento_Status;

	@OneToMany(mappedBy = "segmento", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<SegmentoUsuario> segmentoUsuarios;

	public Segmento() {

	}

	public Segmento(Integer segmento_id, String segmento_descricao, int segmento_Status,
			List<SegmentoUsuario> segmentoUsuarios) {
		super();
		this.segmento_id = segmento_id;
		this.segmento_descricao = segmento_descricao;
		this.segmento_Status = segmento_Status;
		this.segmentoUsuarios = segmentoUsuarios;
	}

	public Integer getSegmento_id() {
		return segmento_id;
	}

	public void setSegmento_id(Integer segmento_id) {
		this.segmento_id = segmento_id;
	}

	public String getSegmento_descricao() {
		return segmento_descricao;
	}

	public void setSegmento_descricao(String segmento_descricao) {
		this.segmento_descricao = segmento_descricao;
	}

	public int getSegmento_Status() {
		return segmento_Status;
	}

	public void setSegmento_Status(int segmento_Status) {
		this.segmento_Status = segmento_Status;
	}

	public List<SegmentoUsuario> getSegmentoUsuarios() {
		return segmentoUsuarios;
	}

	public void setSegmentoUsuarios(List<SegmentoUsuario> segmentoUsuarios) {
		this.segmentoUsuarios = segmentoUsuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}