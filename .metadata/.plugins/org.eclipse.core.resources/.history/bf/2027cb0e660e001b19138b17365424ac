package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ga_template_campo database table.
 * 
 */
@Embeddable
public class GaTemplateCampoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_compania")
	private int codCompania;

	@Column(name="cod_campo")
	private String codCampo;

	public GaTemplateCampoPK() {
	}
	public int getCodCompania() {
		return this.codCompania;
	}
	public void setCodCompania(int codCompania) {
		this.codCompania = codCompania;
	}
	public String getCodCampo() {
		return this.codCampo;
	}
	public void setCodCampo(String codCampo) {
		this.codCampo = codCampo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GaTemplateCampoPK)) {
			return false;
		}
		GaTemplateCampoPK castOther = (GaTemplateCampoPK)other;
		return 
			(this.codCompania == castOther.codCompania)
			&& this.codCampo.equals(castOther.codCampo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codCompania;
		hash = hash * prime + this.codCampo.hashCode();
		
		return hash;
	}
}