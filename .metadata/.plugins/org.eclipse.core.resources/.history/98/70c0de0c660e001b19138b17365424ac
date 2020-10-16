package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ct_campaign database table.
 * 
 */
@Embeddable
public class CtCampaignPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_compania")
	private int codCompania;

	@Column(name="cod_campaign")
	private int codCampaign;

	public CtCampaignPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CtCampaignPK)) {
			return false;
		}
		CtCampaignPK castOther = (CtCampaignPK)other;
		return 
			(this.codCompania == castOther.codCompania)
			&& (this.codCampaign == castOther.codCampaign);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codCompania;
		hash = hash * prime + this.codCampaign;
		
		return hash;
	}
}