package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_ciudad database table.
 * 
 */
@Entity
@Table(name="ga_ciudad")
@NamedQuery(name="GaCiudad.findAll", query="SELECT g FROM GaCiudad g")
public class GaCiudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GaCiudadPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="nom_ciudad")
	private String nomCiudad;

	public GaCiudad() {
	}

	public GaCiudadPK getId() {
		return this.id;
	}

	public void setId(GaCiudadPK id) {
		this.id = id;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getNomCiudad() {
		return this.nomCiudad;
	}

	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}

}