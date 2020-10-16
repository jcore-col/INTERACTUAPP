package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ct_campaign_entry database table.
 * 
 */
@Embeddable
public class CtCampaignEntryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_compania")
	private int codCompania;

	@Column(name="cod_campaign")
	private int codCampaign;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_entry")
	private java.util.Date fecEntry;

	@Column(name="num_secu_entry_day")
	private int numSecuEntryDay;

	public CtCampaignEntryPK() {
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
	public java.util.Date getFecEntry() {
		return this.fecEntry;
	}
	public void setFecEntry(java.util.Date fecEntry) {
		this.fecEntry = fecEntry;
	}
	public int getNumSecuEntryDay() {
		return this.numSecuEntryDay;
	}
	public void setNumSecuEntryDay(int numSecuEntryDay) {
		this.numSecuEntryDay = numSecuEntryDay;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CtCampaignEntryPK)) {
			return false;
		}
		CtCampaignEntryPK castOther = (CtCampaignEntryPK)other;
		return 
			(this.codCompania == castOther.codCompania)
			&& (this.codCampaign == castOther.codCampaign)
			&& this.fecEntry.equals(castOther.fecEntry)
			&& (this.numSecuEntryDay == castOther.numSecuEntryDay);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codCompania;
		hash = hash * prime + this.codCampaign;
		hash = hash * prime + this.fecEntry.hashCode();
		hash = hash * prime + this.numSecuEntryDay;
		
		return hash;
	}
}