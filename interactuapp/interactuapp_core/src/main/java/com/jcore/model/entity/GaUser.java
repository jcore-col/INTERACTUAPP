package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_user database table.
 * 
 */
@Entity
@Table(name="ga_user")
@NamedQuery(name="GaUser.findAll", query="SELECT g FROM GaUser g")
public class GaUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_usr")
	private String codUsr;

	@Column(name="cambiar_contrasena")
	private String cambiarContrasena;

	@Column(name="cod_idioma")
	private String codIdioma;

	@Column(name="email_autenticacion")
	private String emailAutenticacion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_expiracion_usr")
	private Date fecExpiracionUsr;

	@Column(name="nom_usr")
	private String nomUsr;

	public GaUser() {
	}

	public String getCodUsr() {
		return this.codUsr;
	}

	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}

	public String getCambiarContrasena() {
		return this.cambiarContrasena;
	}

	public void setCambiarContrasena(String cambiarContrasena) {
		this.cambiarContrasena = cambiarContrasena;
	}

	public String getCodIdioma() {
		return this.codIdioma;
	}

	public void setCodIdioma(String codIdioma) {
		this.codIdioma = codIdioma;
	}

	public String getEmailAutenticacion() {
		return this.emailAutenticacion;
	}

	public void setEmailAutenticacion(String emailAutenticacion) {
		this.emailAutenticacion = emailAutenticacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public Date getFecExpiracionUsr() {
		return this.fecExpiracionUsr;
	}

	public void setFecExpiracionUsr(Date fecExpiracionUsr) {
		this.fecExpiracionUsr = fecExpiracionUsr;
	}

	public String getNomUsr() {
		return this.nomUsr;
	}

	public void setNomUsr(String nomUsr) {
		this.nomUsr = nomUsr;
	}

}