package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ct_general_tercero database table.
 * 
 */
@Entity
@Table(name="ct_general_tercero")
@NamedQuery(name="CtGeneralTercero.findAll", query="SELECT c FROM CtGeneralTercero c")
public class CtGeneralTercero implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CtGeneralTerceroPK id;

	@Column(name="apellido_tercero")
	private String apellidoTercero;

	@Column(name="cod_causa_inh_trc")
	private int codCausaInhTrc;

	@Column(name="cod_compensacion")
	private int codCompensacion;

	@Column(name="cod_est_civil")
	private String codEstCivil;

	@Column(name="cod_estado")
	private String codEstado;

	@Column(name="cod_idioma")
	private String codIdioma;

	@Column(name="cod_localidad")
	private String codLocalidad;

	@Column(name="cod_pais")
	private String codPais;

	@Column(name="cod_postal")
	private String codPostal;

	@Column(name="cod_profesion")
	private int codProfesion;

	@Column(name="cod_prov")
	private String codProv;

	@Column(name="cod_tercero")
	private int codTercero;

	@Column(name="cod_usr")
	private String codUsr;

	private String domicilio1;

	private String domicilio2;

	private String domicilio3;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_nacimiento")
	private Date fecNacimiento;

	@Column(name="mca_inh")
	private String mcaInh;

	@Column(name="mca_sexo")
	private String mcaSexo;

	@Column(name="nom_localidad")
	private String nomLocalidad;

	@Column(name="nom_tercero")
	private String nomTercero;

	@Column(name="num_apartado")
	private String numApartado;

	@Column(name="obs_tercero")
	private String obsTercero;

	@Column(name="tip_act_economica")
	private int tipActEconomica;

	@Column(name="tip_cargo")
	private int tipCargo;

	@Column(name="tip_domicilio")
	private int tipDomicilio;

	@Column(name="tlf_numero")
	private String tlfNumero;

	@Column(name="tlf_pais")
	private String tlfPais;

	public CtGeneralTercero() {
	}

	public CtGeneralTerceroPK getId() {
		return this.id;
	}

	public void setId(CtGeneralTerceroPK id) {
		this.id = id;
	}

	public String getApellidoTercero() {
		return this.apellidoTercero;
	}

	public void setApellidoTercero(String apellidoTercero) {
		this.apellidoTercero = apellidoTercero;
	}

	public int getCodCausaInhTrc() {
		return this.codCausaInhTrc;
	}

	public void setCodCausaInhTrc(int codCausaInhTrc) {
		this.codCausaInhTrc = codCausaInhTrc;
	}

	public int getCodCompensacion() {
		return this.codCompensacion;
	}

	public void setCodCompensacion(int codCompensacion) {
		this.codCompensacion = codCompensacion;
	}

	public String getCodEstCivil() {
		return this.codEstCivil;
	}

	public void setCodEstCivil(String codEstCivil) {
		this.codEstCivil = codEstCivil;
	}

	public String getCodEstado() {
		return this.codEstado;
	}

	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

	public String getCodIdioma() {
		return this.codIdioma;
	}

	public void setCodIdioma(String codIdioma) {
		this.codIdioma = codIdioma;
	}

	public String getCodLocalidad() {
		return this.codLocalidad;
	}

	public void setCodLocalidad(String codLocalidad) {
		this.codLocalidad = codLocalidad;
	}

	public String getCodPais() {
		return this.codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public String getCodPostal() {
		return this.codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public int getCodProfesion() {
		return this.codProfesion;
	}

	public void setCodProfesion(int codProfesion) {
		this.codProfesion = codProfesion;
	}

	public String getCodProv() {
		return this.codProv;
	}

	public void setCodProv(String codProv) {
		this.codProv = codProv;
	}

	public int getCodTercero() {
		return this.codTercero;
	}

	public void setCodTercero(int codTercero) {
		this.codTercero = codTercero;
	}

	public String getCodUsr() {
		return this.codUsr;
	}

	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}

	public String getDomicilio1() {
		return this.domicilio1;
	}

	public void setDomicilio1(String domicilio1) {
		this.domicilio1 = domicilio1;
	}

	public String getDomicilio2() {
		return this.domicilio2;
	}

	public void setDomicilio2(String domicilio2) {
		this.domicilio2 = domicilio2;
	}

	public String getDomicilio3() {
		return this.domicilio3;
	}

	public void setDomicilio3(String domicilio3) {
		this.domicilio3 = domicilio3;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public Date getFecNacimiento() {
		return this.fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getMcaInh() {
		return this.mcaInh;
	}

	public void setMcaInh(String mcaInh) {
		this.mcaInh = mcaInh;
	}

	public String getMcaSexo() {
		return this.mcaSexo;
	}

	public void setMcaSexo(String mcaSexo) {
		this.mcaSexo = mcaSexo;
	}

	public String getNomLocalidad() {
		return this.nomLocalidad;
	}

	public void setNomLocalidad(String nomLocalidad) {
		this.nomLocalidad = nomLocalidad;
	}

	public String getNomTercero() {
		return this.nomTercero;
	}

	public void setNomTercero(String nomTercero) {
		this.nomTercero = nomTercero;
	}

	public String getNumApartado() {
		return this.numApartado;
	}

	public void setNumApartado(String numApartado) {
		this.numApartado = numApartado;
	}

	public String getObsTercero() {
		return this.obsTercero;
	}

	public void setObsTercero(String obsTercero) {
		this.obsTercero = obsTercero;
	}

	public int getTipActEconomica() {
		return this.tipActEconomica;
	}

	public void setTipActEconomica(int tipActEconomica) {
		this.tipActEconomica = tipActEconomica;
	}

	public int getTipCargo() {
		return this.tipCargo;
	}

	public void setTipCargo(int tipCargo) {
		this.tipCargo = tipCargo;
	}

	public int getTipDomicilio() {
		return this.tipDomicilio;
	}

	public void setTipDomicilio(int tipDomicilio) {
		this.tipDomicilio = tipDomicilio;
	}

	public String getTlfNumero() {
		return this.tlfNumero;
	}

	public void setTlfNumero(String tlfNumero) {
		this.tlfNumero = tlfNumero;
	}

	public String getTlfPais() {
		return this.tlfPais;
	}

	public void setTlfPais(String tlfPais) {
		this.tlfPais = tlfPais;
	}

}