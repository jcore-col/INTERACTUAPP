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

	@Column(name="cod_estado")
	private String codEstado;

	@Column(name="cod_localidad")
	private String codLocalidad;

	@Column(name="cod_pais")
	private String codPais;

	@Column(name="cod_postal")
	private String codPostal;

	@Column(name="cod_prov")
	private String codProv;

	@Column(name="cod_usr")
	private String codUsr;

	@Column(name="create_by")
	private String createBy;

	private String domicilio1;

	private String domicilio2;

	private String domicilio3;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_entry")
	private Date fecEntry;

	@Column(name="mca_inh")
	private String mcaInh;

	@Column(name="nom_localidad")
	private String nomLocalidad;

	@Column(name="num_apartado")
	private String numApartado;

	@Column(name="num_interactions")
	private int numInteractions;

	@Column(name="tip_situacion")
	private String tipSituacion;

	public CtCampaignEntry() {
		this.id = new CtCampaignEntryPK();
	}

	public CtCampaignEntryPK getId() {
		return this.id;
	}

	public void setId(CtCampaignEntryPK id) {
		this.id = id;
	}

	public String getCodEstado() {
		return this.codEstado;
	}

	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

	public String getCodLocalidad() {
		return this.codLocalidad;
	}

	public void setCodLocalidad(String codLocalidad) {
		this.codLocalidad = codLocalidad;
	}

	public String getCodPais() {
		return this.codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public String getCodPostal() {
		return this.codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getCodProv() {
		return this.codProv;
	}

	public void setCodProv(String codProv) {
		this.codProv = codProv;
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

	public String getDomicilio1() {
		return this.domicilio1;
	}

	public void setDomicilio1(String domicilio1) {
		this.domicilio1 = domicilio1;
	}

	public String getDomicilio2() {
		return this.domicilio2;
	}

	public void setDomicilio2(String domicilio2) {
		this.domicilio2 = domicilio2;
	}

	public String getDomicilio3() {
		return this.domicilio3;
	}

	public void setDomicilio3(String domicilio3) {
		this.domicilio3 = domicilio3;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public Date getFecEntry() {
		return this.fecEntry;
	}

	public void setFecEntry(Date fecEntry) {
		this.fecEntry = fecEntry;
	}

	public String getMcaInh() {
		return this.mcaInh;
	}

	public void setMcaInh(String mcaInh) {
		this.mcaInh = mcaInh;
	}

	public String getNomLocalidad() {
		return this.nomLocalidad;
	}

	public void setNomLocalidad(String nomLocalidad) {
		this.nomLocalidad = nomLocalidad;
	}

	public String getNumApartado() {
		return this.numApartado;
	}

	public void setNumApartado(String numApartado) {
		this.numApartado = numApartado;
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