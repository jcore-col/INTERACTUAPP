package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ga_template_help_campo database table.
 * 
 */
@Embeddable
public class GaTemplateHelpCampoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_compania")
	private int codCompania;

	@Column(name="cod_campo")
	private String codCampo;

	@Column(name="cod_valor")
	private String codValor;

	@Column(name="cod_idioma")
	private String codIdioma;

	public GaTemplateHelpCampoPK() {
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
	public String getCodValor() {
		return this.codValor;
	}
	public void setCodValor(String codValor) {
		this.codValor = codValor;
	}
	public String getCodIdioma() {
		return this.codIdioma;
	}
	public void setCodIdioma(String codIdioma) {
		this.codIdioma = codIdioma;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GaTemplateHelpCampoPK)) {
			return false;
		}
		GaTemplateHelpCampoPK castOther = (GaTemplateHelpCampoPK)other;
		return 
			(this.codCompania == castOther.codCompania)
			&& this.codCampo.equals(castOther.codCampo)
			&& this.codValor.equals(castOther.codValor)
			&& this.codIdioma.equals(castOther.codIdioma);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codCompania;
		hash = hash * prime + this.codCampo.hashCode();
		hash = hash * prime + this.codValor.hashCode();
		hash = hash * prime + this.codIdioma.hashCode();
		
		return hash;
	}
}