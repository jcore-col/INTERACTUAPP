package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ct_general_tercero database table.
 * 
 */
@Embeddable
public class CtGeneralTerceroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_compania")
	private int codCompania;

	@Column(name="tip_docum")
	private String tipDocum;

	@Column(name="cod_docum")
	private String codDocum;

	@Column(name="cod_act_tercero")
	private int codActTercero;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_validez")
	private java.util.Date fecValidez;

	public CtGeneralTerceroPK() {
	}
	public int getCodCompania() {
		return this.codCompania;
	}
	public void setCodCompania(int codCompania) {
		this.codCompania = codCompania;
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
	public int getCodActTercero() {
		return this.codActTercero;
	}
	public void setCodActTercero(int codActTercero) {
		this.codActTercero = codActTercero;
	}
	public java.util.Date getFecValidez() {
		return this.fecValidez;
	}
	public void setFecValidez(java.util.Date fecValidez) {
		this.fecValidez = fecValidez;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CtGeneralTerceroPK)) {
			return false;
		}
		CtGeneralTerceroPK castOther = (CtGeneralTerceroPK)other;
		return 
			(this.codCompania == castOther.codCompania)
			&& this.tipDocum.equals(castOther.tipDocum)
			&& this.codDocum.equals(castOther.codDocum)
			&& (this.codActTercero == castOther.codActTercero)
			&& this.fecValidez.equals(castOther.fecValidez);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codCompania;
		hash = hash * prime + this.tipDocum.hashCode();
		hash = hash * prime + this.codDocum.hashCode();
		hash = hash * prime + this.codActTercero;
		hash = hash * prime + this.fecValidez.hashCode();
		
		return hash;
	}
}