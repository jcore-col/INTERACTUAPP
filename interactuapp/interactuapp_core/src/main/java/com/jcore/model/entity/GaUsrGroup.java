package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_usr_group database table.
 * 
 */
@Entity
@Table(name="ga_usr_group")
@NamedQuery(name="GaUsrGroup.findAll", query="SELECT g FROM GaUsrGroup g")
public class GaUsrGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GaUsrGroupPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="nom_usr_group")
	private String nomUsrGroup;

	public GaUsrGroup() {
	}

	public GaUsrGroupPK getId() {
		return this.id;
	}

	public void setId(GaUsrGroupPK id) {
		this.id = id;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getNomUsrGroup() {
		return this.nomUsrGroup;
	}

	public void setNomUsrGroup(String nomUsrGroup) {
		this.nomUsrGroup = nomUsrGroup;
	}

}