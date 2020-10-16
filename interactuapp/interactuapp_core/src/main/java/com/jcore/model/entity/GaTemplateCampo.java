package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ga_template_campo database table.
 * 
 */
@Entity
@Table(name="ga_template_campo")
@NamedQuery(name="GaTemplateCampo.findAll", query="SELECT g FROM GaTemplateCampo g")
public class GaTemplateCampo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GaTemplateCampoPK id;

	@Column(name="format_campo")
	private String formatCampo;

	@Column(name="long_campo")
	private int longCampo;

	@Column(name="mca_inh")
	private String mcaInh;

	@Column(name="mca_obligatorio")
	private String mcaObligatorio;

	@Column(name="mca_trim")
	private String mcaTrim;

	@Column(name="mca_txt_uppercase")
	private String mcaTxtUppercase;

	@Column(name="mca_validacion")
	private String mcaValidacion;

	@Column(name="nom_campo")
	private String nomCampo;

	@Column(name="nom_prg_ayuda")
	private String nomPrgAyuda;

	@Column(name="nom_prg_validacion")
	private String nomPrgValidacion;

	@Column(name="num_max_valor")
	private int numMaxValor;

	@Column(name="num_min_valor")
	private int numMinValor;

	@Column(name="tip_campo")
	private String tipCampo;

	@Column(name="val_defecto")
	private String valDefecto;

	public GaTemplateCampo() {
	}

	public GaTemplateCampoPK getId() {
		return this.id;
	}

	public void setId(GaTemplateCampoPK id) {
		this.id = id;
	}

	public String getFormatCampo() {
		return this.formatCampo;
	}

	public void setFormatCampo(String formatCampo) {
		this.formatCampo = formatCampo;
	}

	public int getLongCampo() {
		return this.longCampo;
	}

	public void setLongCampo(int longCampo) {
		this.longCampo = longCampo;
	}

	public String getMcaInh() {
		return this.mcaInh;
	}

	public void setMcaInh(String mcaInh) {
		this.mcaInh = mcaInh;
	}

	public String getMcaObligatorio() {
		return this.mcaObligatorio;
	}

	public void setMcaObligatorio(String mcaObligatorio) {
		this.mcaObligatorio = mcaObligatorio;
	}

	public String getMcaTrim() {
		return this.mcaTrim;
	}

	public void setMcaTrim(String mcaTrim) {
		this.mcaTrim = mcaTrim;
	}

	public String getMcaTxtUppercase() {
		return this.mcaTxtUppercase;
	}

	public void setMcaTxtUppercase(String mcaTxtUppercase) {
		this.mcaTxtUppercase = mcaTxtUppercase;
	}

	public String getMcaValidacion() {
		return this.mcaValidacion;
	}

	public void setMcaValidacion(String mcaValidacion) {
		this.mcaValidacion = mcaValidacion;
	}

	public String getNomCampo() {
		return this.nomCampo;
	}

	public void setNomCampo(String nomCampo) {
		this.nomCampo = nomCampo;
	}

	public String getNomPrgAyuda() {
		return this.nomPrgAyuda;
	}

	public void setNomPrgAyuda(String nomPrgAyuda) {
		this.nomPrgAyuda = nomPrgAyuda;
	}

	public String getNomPrgValidacion() {
		return this.nomPrgValidacion;
	}

	public void setNomPrgValidacion(String nomPrgValidacion) {
		this.nomPrgValidacion = nomPrgValidacion;
	}

	public int getNumMaxValor() {
		return this.numMaxValor;
	}

	public void setNumMaxValor(int numMaxValor) {
		this.numMaxValor = numMaxValor;
	}

	public int getNumMinValor() {
		return this.numMinValor;
	}

	public void setNumMinValor(int numMinValor) {
		this.numMinValor = numMinValor;
	}

	public String getTipCampo() {
		return this.tipCampo;
	}

	public void setTipCampo(String tipCampo) {
		this.tipCampo = tipCampo;
	}

	public String getValDefecto() {
		return this.valDefecto;
	}

	public void setValDefecto(String valDefecto) {
		this.valDefecto = valDefecto;
	}

}