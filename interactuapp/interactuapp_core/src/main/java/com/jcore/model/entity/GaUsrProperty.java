package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_usr_property database table.
 * 
 */
@Entity
@Table(name="ga_usr_property")
@NamedQuery(name="GaUsrProperty.findAll", query="SELECT g FROM GaUsrProperty g")
public class GaUsrProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_usr")
	private String codUsr;

	@Column(name="acceso_sin_clave")
	private String accesoSinClave;

	@Column(name="cadenacon_bd")
	private String cadenaconBd;

	@Column(name="clave_acceso")
	private String claveAcceso;

	@Column(name="cod_campaign")
	private int codCampaign;

	@Column(name="cod_compania")
	private int codCompania;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_ultima_mod_clave")
	private Date fecUltimaModClave;

	@Column(name="mca_cambiar_contrasena")
	private String mcaCambiarContrasena;

	@Column(name="mca_obligar_letras")
	private String mcaObligarLetras;

	@Column(name="mca_obligar_num")
	private String mcaObligarNum;

	@Column(name="num_dias_limite_clave")
	private int numDiasLimiteClave;

	@Column(name="num_maxima_long_clave")
	private int numMaximaLongClave;

	@Column(name="num_minima_long_clave")
	private int numMinimaLongClave;

	public GaUsrProperty() {
	}

	public String getCodUsr() {
		return this.codUsr;
	}

	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}

	public String getAccesoSinClave() {
		return this.accesoSinClave;
	}

	public void setAccesoSinClave(String accesoSinClave) {
		this.accesoSinClave = accesoSinClave;
	}

	public String getCadenaconBd() {
		return this.cadenaconBd;
	}

	public void setCadenaconBd(String cadenaconBd) {
		this.cadenaconBd = cadenaconBd;
	}

	public String getClaveAcceso() {
		return this.claveAcceso;
	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}

	public int getCodCampaign() {
		return this.codCampaign;
	}

	public void setCodCampaign(int codCampaign) {
		this.codCampaign = codCampaign;
	}

	public int getCodCompania() {
		return this.codCompania;
	}

	public void setCodCompania(int codCompania) {
		this.codCompania = codCompania;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public Date getFecUltimaModClave() {
		return this.fecUltimaModClave;
	}

	public void setFecUltimaModClave(Date fecUltimaModClave) {
		this.fecUltimaModClave = fecUltimaModClave;
	}

	public String getMcaCambiarContrasena() {
		return this.mcaCambiarContrasena;
	}

	public void setMcaCambiarContrasena(String mcaCambiarContrasena) {
		this.mcaCambiarContrasena = mcaCambiarContrasena;
	}

	public String getMcaObligarLetras() {
		return this.mcaObligarLetras;
	}

	public void setMcaObligarLetras(String mcaObligarLetras) {
		this.mcaObligarLetras = mcaObligarLetras;
	}

	public String getMcaObligarNum() {
		return this.mcaObligarNum;
	}

	public void setMcaObligarNum(String mcaObligarNum) {
		this.mcaObligarNum = mcaObligarNum;
	}

	public int getNumDiasLimiteClave() {
		return this.numDiasLimiteClave;
	}

	public void setNumDiasLimiteClave(int numDiasLimiteClave) {
		this.numDiasLimiteClave = numDiasLimiteClave;
	}

	public int getNumMaximaLongClave() {
		return this.numMaximaLongClave;
	}

	public void setNumMaximaLongClave(int numMaximaLongClave) {
		this.numMaximaLongClave = numMaximaLongClave;
	}

	public int getNumMinimaLongClave() {
		return this.numMinimaLongClave;
	}

	public void setNumMinimaLongClave(int numMinimaLongClave) {
		this.numMinimaLongClave = numMinimaLongClave;
	}

}