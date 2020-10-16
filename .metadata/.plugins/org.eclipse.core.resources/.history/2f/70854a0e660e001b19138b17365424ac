package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ga_localidad database table.
 * 
 */
@Embeddable
public class GaLocalidadPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_pais")
	private String codPais;

	@Column(name="cod_ciudad")
	private String codCiudad;

	@Column(name="cod_localidad")
	private String codLocalidad;

	public GaLocalidadPK() {
	}
	public String getCodPais() {
		return this.codPais;
	}
	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}
	public String getCodCiudad() {
		return this.codCiudad;
	}
	public void setCodCiudad(String codCiudad) {
		this.codCiudad = codCiudad;
	}
	public String getCodLocalidad() {
		return this.codLocalidad;
	}
	public void setCodLocalidad(String codLocalidad) {
		this.codLocalidad = codLocalidad;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GaLocalidadPK)) {
			return false;
		}
		GaLocalidadPK castOther = (GaLocalidadPK)other;
		return 
			this.codPais.equals(castOther.codPais)
			&& this.codCiudad.equals(castOther.codCiudad)
			&& this.codLocalidad.equals(castOther.codLocalidad);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codPais.hashCode();
		hash = hash * prime + this.codCiudad.hashCode();
		hash = hash * prime + this.codLocalidad.hashCode();
		
		return hash;
	}
}