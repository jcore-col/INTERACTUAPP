package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_pais database table.
 * 
 */
@Entity
@Table(name="ga_pais")
@NamedQuery(name="GaPai.findAll", query="SELECT g FROM GaPai g")
public class GaPai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_pais")
	private String codPais;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="nom_pais")
	private String nomPais;

	public GaPai() {
	}

	public String getCodPais() {
		return this.codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getNomPais() {
		return this.nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}

}