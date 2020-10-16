package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_localidad database table.
 * 
 */
@Entity
@Table(name="ga_localidad")
@NamedQuery(name="GaLocalidad.findAll", query="SELECT g FROM GaLocalidad g")
public class GaLocalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GaLocalidadPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="nom_localidad")
	private String nomLocalidad;

	public GaLocalidad() {
	}

	public GaLocalidadPK getId() {
		return this.id;
	}

	public void setId(GaLocalidadPK id) {
		this.id = id;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getNomLocalidad() {
		return this.nomLocalidad;
	}

	public void setNomLocalidad(String nomLocalidad) {
		this.nomLocalidad = nomLocalidad;
	}

}