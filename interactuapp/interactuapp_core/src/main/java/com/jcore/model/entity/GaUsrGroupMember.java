package com.jcore.model.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_usr_group_member database table.
 * 
 */
@Entity
@Table(name="ga_usr_group_member")
@NamedQuery(name="GaUsrGroupMember.findAll", query="SELECT g FROM GaUsrGroupMember g")
public class GaUsrGroupMember implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GaUsrGroupMemberPK id;

	@Column(name="cod_docum")
	private String codDocum;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="nom_usr")
	private String nomUsr;

	@Column(name="nom_usr_group")
	private String nomUsrGroup;

	@Column(name="tip_docum")
	private String tipDocum;

	public GaUsrGroupMember() {
		this.id = new GaUsrGroupMemberPK();
	}

	public GaUsrGroupMemberPK getId() {
		return this.id;
	}

	public void setId(GaUsrGroupMemberPK id) {
		this.id = id;
	}

	public String getCodDocum() {
		return this.codDocum;
	}

	public void setCodDocum(String codDocum) {
		this.codDocum = codDocum;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getNomUsr() {
		return this.nomUsr;
	}

	public void setNomUsr(String nomUsr) {
		this.nomUsr = nomUsr;
	}

	public String getNomUsrGroup() {
		return this.nomUsrGroup;
	}

	public void setNomUsrGroup(String nomUsrGroup) {
		this.nomUsrGroup = nomUsrGroup;
	}

	public String getTipDocum() {
		return this.tipDocum;
	}

	public void setTipDocum(String tipDocum) {
		this.tipDocum = tipDocum;
	}

}