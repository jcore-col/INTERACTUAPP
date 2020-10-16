package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_codigos_postal database table.
 * 
 */
@Entity
@Table(name="ga_codigos_postal")
@NamedQuery(name="GaCodigosPostal.findAll", query="SELECT g FROM GaCodigosPostal g")
public class GaCodigosPostal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GaCodigosPostalPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	public GaCodigosPostal() {
	}

	public GaCodigosPostalPK getId() {
		return this.id;
	}

	public void setId(GaCodigosPostalPK id) {
		this.id = id;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

}