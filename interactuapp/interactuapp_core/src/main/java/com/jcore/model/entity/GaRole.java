package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_roles database table.
 * 
 */
@Entity
@Table(name="ga_roles")
@NamedQuery(name="GaRole.findAll", query="SELECT g FROM GaRole g")
public class GaRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_rol")
	private String codRol;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="nom_rol")
	private String nomRol;

	public GaRole() {
	}

	public String getCodRol() {
		return this.codRol;
	}

	public void setCodRol(String codRol) {
		this.codRol = codRol;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getNomRol() {
		return this.nomRol;
	}

	public void setNomRol(String nomRol) {
		this.nomRol = nomRol;
	}

}