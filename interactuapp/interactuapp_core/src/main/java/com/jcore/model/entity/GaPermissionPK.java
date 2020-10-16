package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ga_permission database table.
 * 
 */
@Embeddable
public class GaPermissionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_rol")
	private String codRol;

	@Column(name="cod_program")
	private String codProgram;

	public GaPermissionPK() {
	}
	public String getCodRol() {
		return this.codRol;
	}
	public void setCodRol(String codRol) {
		this.codRol = codRol;
	}
	public String getCodProgram() {
		return this.codProgram;
	}
	public void setCodProgram(String codProgram) {
		this.codProgram = codProgram;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GaPermissionPK)) {
			return false;
		}
		GaPermissionPK castOther = (GaPermissionPK)other;
		return 
			this.codRol.equals(castOther.codRol)
			&& this.codProgram.equals(castOther.codProgram);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codRol.hashCode();
		hash = hash * prime + this.codProgram.hashCode();
		
		return hash;
	}
}