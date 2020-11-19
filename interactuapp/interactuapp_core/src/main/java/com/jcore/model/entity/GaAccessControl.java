package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_access_control database table.
 * 
 */
@Entity
@Table(name="ga_access_control")
@NamedQuery(name="GaAccessControl.findAll", query="SELECT g FROM GaAccessControl g")
public class GaAccessControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GaAccessControlPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="nom_rol")
	private String nomRol;

	@Column(name="nom_usr")
	private String nomUsr;

	public GaAccessControl() {
		this.id = new GaAccessControlPK();
	}

	public GaAccessControlPK getId() {
		return this.id;
	}

	public void setId(GaAccessControlPK id) {
		this.id = id;
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

	public String getNomUsr() {
		return this.nomUsr;
	}

	public void setNomUsr(String nomUsr) {
		this.nomUsr = nomUsr;
	}

}