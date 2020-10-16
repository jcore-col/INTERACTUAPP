package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ga_access_control database table.
 * 
 */
@Embeddable
public class GaAccessControlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_usr")
	private String codUsr;

	@Column(name="cod_rol")
	private String codRol;

	public GaAccessControlPK() {
	}
	public String getCodUsr() {
		return this.codUsr;
	}
	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}
	public String getCodRol() {
		return this.codRol;
	}
	public void setCodRol(String codRol) {
		this.codRol = codRol;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GaAccessControlPK)) {
			return false;
		}
		GaAccessControlPK castOther = (GaAccessControlPK)other;
		return 
			this.codUsr.equals(castOther.codUsr)
			&& this.codRol.equals(castOther.codRol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codUsr.hashCode();
		hash = hash * prime + this.codRol.hashCode();
		
		return hash;
	}
}