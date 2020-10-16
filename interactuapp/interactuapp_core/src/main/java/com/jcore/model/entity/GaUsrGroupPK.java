package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ga_usr_group database table.
 * 
 */
@Embeddable
public class GaUsrGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_compania")
	private String codCompania;

	@Column(name="cod_grp_usr")
	private String codGrpUsr;

	public GaUsrGroupPK() {
	}
	public String getCodCompania() {
		return this.codCompania;
	}
	public void setCodCompania(String codCompania) {
		this.codCompania = codCompania;
	}
	public String getCodGrpUsr() {
		return this.codGrpUsr;
	}
	public void setCodGrpUsr(String codGrpUsr) {
		this.codGrpUsr = codGrpUsr;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GaUsrGroupPK)) {
			return false;
		}
		GaUsrGroupPK castOther = (GaUsrGroupPK)other;
		return 
			this.codCompania.equals(castOther.codCompania)
			&& this.codGrpUsr.equals(castOther.codGrpUsr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codCompania.hashCode();
		hash = hash * prime + this.codGrpUsr.hashCode();
		
		return hash;
	}
}