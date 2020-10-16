package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ct_campaign database table.
 * 
 */
@Entity
@Table(name="ct_campaign")
@NamedQuery(name="CtCampaign.findAll", query="SELECT c FROM CtCampaign c")
public class CtCampaign implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CtCampaignPK id;

	@Column(name="cod_usr")
	private String codUsr;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_fin_vig")
	private Date fecFinVig;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_ini_vig")
	private Date fecIniVig;

	@Column(name="mca_inh")
	private String mcaInh;

	@Column(name="nom_campaign")
	private String nomCampaign;

	@Column(name="tip_situacion")
	private String tipSituacion;

	public CtCampaign() {
	}

	public CtCampaignPK getId() {
		return this.id;
	}

	public void setId(CtCampaignPK id) {
		this.id = id;
	}

	public String getCodUsr() {
		return this.codUsr;
	}

	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public Date getFecFinVig() {
		return this.fecFinVig;
	}

	public void setFecFinVig(Date fecFinVig) {
		this.fecFinVig = fecFinVig;
	}

	public Date getFecIniVig() {
		return this.fecIniVig;
	}

	public void setFecIniVig(Date fecIniVig) {
		this.fecIniVig = fecIniVig;
	}

	public String getMcaInh() {
		return this.mcaInh;
	}

	public void setMcaInh(String mcaInh) {
		this.mcaInh = mcaInh;
	}

	public String getNomCampaign() {
		return this.nomCampaign;
	}

	public void setNomCampaign(String nomCampaign) {
		this.nomCampaign = nomCampaign;
	}

	public String getTipSituacion() {
		return this.tipSituacion;
	}

	public void setTipSituacion(String tipSituacion) {
		this.tipSituacion = tipSituacion;
	}

}