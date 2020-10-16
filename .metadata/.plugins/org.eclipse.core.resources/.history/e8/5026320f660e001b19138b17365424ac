package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ga_usr_group_member database table.
 * 
 */
@Embeddable
public class GaUsrGroupMemberPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_compania")
	private String codCompania;

	@Column(name="cod_usr")
	private String codUsr;

	@Column(name="cod_grp_usr")
	private String codGrpUsr;

	public GaUsrGroupMemberPK() {
	}
	public String getCodCompania() {
		return this.codCompania;
	}
	public void setCodCompania(String codCompania) {
		this.codCompania = codCompania;
	}
	public String getCodUsr() {
		return this.codUsr;
	}
	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
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
		if (!(other instanceof GaUsrGroupMemberPK)) {
			return false;
		}
		GaUsrGroupMemberPK castOther = (GaUsrGroupMemberPK)other;
		return 
			this.codCompania.equals(castOther.codCompania)
			&& this.codUsr.equals(castOther.codUsr)
			&& this.codGrpUsr.equals(castOther.codGrpUsr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codCompania.hashCode();
		hash = hash * prime + this.codUsr.hashCode();
		hash = hash * prime + this.codGrpUsr.hashCode();
		
		return hash;
	}
}