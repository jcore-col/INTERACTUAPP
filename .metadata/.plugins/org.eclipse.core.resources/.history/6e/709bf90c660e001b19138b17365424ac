package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ct_campaign_entry database table.
 * 
 */
@Entity
@Table(name="ct_campaign_entry")
@NamedQuery(name="CtCampaignEntry.findAll", query="SELECT c FROM CtCampaignEntry c")
public class CtCampaignEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CtCampaignEntryPK id;

	@Column(name="cod_usr")
	private String codUsr;

	@Column(name="create_by")
	private String createBy;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="mca_inh")
	private String mcaInh;

	@Column(name="num_interactions")
	private int numInteractions;

	@Column(name="tip_situacion")
	private String tipSituacion;

	public CtCampaignEntry() {
	}

	public CtCampaignEntryPK getId() {
		return this.id;
	}

	public void setId(CtCampaignEntryPK id) {
		this.id = id;
	}

	public String getCodUsr() {
		return this.codUsr;
	}

	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getMcaInh() {
		return this.mcaInh;
	}

	public void setMcaInh(String mcaInh) {
		this.mcaInh = mcaInh;
	}

	public int getNumInteractions() {
		return this.numInteractions;
	}

	public void setNumInteractions(int numInteractions) {
		this.numInteractions = numInteractions;
	}

	public String getTipSituacion() {
		return this.tipSituacion;
	}

	public void setTipSituacion(String tipSituacion) {
		this.tipSituacion = tipSituacion;
	}

}