package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ct_log_person_registry database table.
 * 
 */
@Embeddable
public class CtLogPersonRegistryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_compania")
	private int codCompania;

	@Column(name="cod_campaign")
	private int codCampaign;

	@Column(name="tip_docum")
	private String tipDocum;

	@Column(name="cod_docum")
	private String codDocum;

	@Column(name="cod_usr")
	private String codUsr;

	public CtLogPersonRegistryPK() {
	}
	public int getCodCompania() {
		return this.codCompania;
	}
	public void setCodCompania(int codCompania) {
		this.codCompania = codCompania;
	}
	public int getCodCampaign() {
		return this.codCampaign;
	}
	public void setCodCampaign(int codCampaign) {
		this.codCampaign = codCampaign;
	}
	public String getTipDocum() {
		return this.tipDocum;
	}
	public void setTipDocum(String tipDocum) {
		this.tipDocum = tipDocum;
	}
	public String getCodDocum() {
		return this.codDocum;
	}
	public void setCodDocum(String codDocum) {
		this.codDocum = codDocum;
	}
	public String getCodUsr() {
		return this.codUsr;
	}
	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CtLogPersonRegistryPK)) {
			return false;
		}
		CtLogPersonRegistryPK castOther = (CtLogPersonRegistryPK)other;
		return 
			(this.codCompania == castOther.codCompania)
			&& (this.codCampaign == castOther.codCampaign)
			&& this.tipDocum.equals(castOther.tipDocum)
			&& this.codDocum.equals(castOther.codDocum)
			&& this.codUsr.equals(castOther.codUsr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codCompania;
		hash = hash * prime + this.codCampaign;
		hash = hash * prime + this.tipDocum.hashCode();
		hash = hash * prime + this.codDocum.hashCode();
		hash = hash * prime + this.codUsr.hashCode();
		
		return hash;
	}
}