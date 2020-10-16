package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_tipos_documento database table.
 * 
 */
@Entity
@Table(name="ga_tipos_documento")
@NamedQuery(name="GaTiposDocumento.findAll", query="SELECT g FROM GaTiposDocumento g")
public class GaTiposDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tip_docum")
	private String tipDocum;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="nom_tip_docum")
	private String nomTipDocum;

	public GaTiposDocumento() {
	}

	public String getTipDocum() {
		return this.tipDocum;
	}

	public void setTipDocum(String tipDocum) {
		this.tipDocum = tipDocum;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getNomTipDocum() {
		return this.nomTipDocum;
	}

	public void setNomTipDocum(String nomTipDocum) {
		this.nomTipDocum = nomTipDocum;
	}

}