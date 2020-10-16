package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_estado database table.
 * 
 */
@Entity
@Table(name="ga_estado")
@NamedQuery(name="GaEstado.findAll", query="SELECT g FROM GaEstado g")
public class GaEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GaEstadoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="nom_estado")
	private String nomEstado;

	public GaEstado() {
	}

	public GaEstadoPK getId() {
		return this.id;
	}

	public void setId(GaEstadoPK id) {
		this.id = id;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getNomEstado() {
		return this.nomEstado;
	}

	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}

}