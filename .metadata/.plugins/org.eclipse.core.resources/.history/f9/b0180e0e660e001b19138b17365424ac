package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_compania database table.
 * 
 */
@Entity
@Table(name="ga_compania")
@NamedQuery(name="GaCompania.findAll", query="SELECT g FROM GaCompania g")
public class GaCompania implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_compania")
	private int codCompania;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="nom_compania")
	private String nomCompania;

	public GaCompania() {
	}

	public int getCodCompania() {
		return this.codCompania;
	}

	public void setCodCompania(int codCompania) {
		this.codCompania = codCompania;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getNomCompania() {
		return this.nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}

}