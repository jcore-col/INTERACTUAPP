package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ct_interaction_log_entry database table.
 * 
 */
@Embeddable
public class CtInteractionLogEntryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_compania")
	private int codCompania;

	@Column(name="cod_campaign")
	private int codCampaign;

	@Column(name="num_secu_entry_day")
	private int numSecuEntryDay;

	@Column(name="tip_docum")
	private String tipDocum;

	@Column(name="cod_docum")
	private String codDocum;

	public CtInteractionLogEntryPK() {
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
	public int getNumSecuEntryDay() {
		return this.numSecuEntryDay;
	}
	public void setNumSecuEntryDay(int numSecuEntryDay) {
		this.numSecuEntryDay = numSecuEntryDay;
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CtInteractionLogEntryPK)) {
			return false;
		}
		CtInteractionLogEntryPK castOther = (CtInteractionLogEntryPK)other;
		return 
			(this.codCompania == castOther.codCompania)
			&& (this.codCampaign == castOther.codCampaign)
			&& (this.numSecuEntryDay == castOther.numSecuEntryDay)
			&& this.tipDocum.equals(castOther.tipDocum)
			&& this.codDocum.equals(castOther.codDocum);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codCompania;
		hash = hash * prime + this.codCampaign;
		hash = hash * prime + this.numSecuEntryDay;
		hash = hash * prime + this.tipDocum.hashCode();
		hash = hash * prime + this.codDocum.hashCode();
		
		return hash;
	}
}