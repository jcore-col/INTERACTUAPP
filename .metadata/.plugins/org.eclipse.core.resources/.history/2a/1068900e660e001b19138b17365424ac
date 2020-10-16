package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_profesion database table.
 * 
 */
@Entity
@Table(name="ga_profesion")
@NamedQuery(name="GaProfesion.findAll", query="SELECT g FROM GaProfesion g")
public class GaProfesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_profesion")
	private int codProfesion;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="nom_profesion")
	private String nomProfesion;

	public GaProfesion() {
	}

	public int getCodProfesion() {
		return this.codProfesion;
	}

	public void setCodProfesion(int codProfesion) {
		this.codProfesion = codProfesion;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getNomProfesion() {
		return this.nomProfesion;
	}

	public void setNomProfesion(String nomProfesion) {
		this.nomProfesion = nomProfesion;
	}

}