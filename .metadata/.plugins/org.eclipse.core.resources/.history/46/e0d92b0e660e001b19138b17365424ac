package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ga_estado database table.
 * 
 */
@Embeddable
public class GaEstadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_pais")
	private String codPais;

	@Column(name="cod_estado")
	private String codEstado;

	public GaEstadoPK() {
	}
	public String getCodPais() {
		return this.codPais;
	}
	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}
	public String getCodEstado() {
		return this.codEstado;
	}
	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GaEstadoPK)) {
			return false;
		}
		GaEstadoPK castOther = (GaEstadoPK)other;
		return 
			this.codPais.equals(castOther.codPais)
			&& this.codEstado.equals(castOther.codEstado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codPais.hashCode();
		hash = hash * prime + this.codEstado.hashCode();
		
		return hash;
	}
}