package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ga_template_help_campo database table.
 * 
 */
@Entity
@Table(name="ga_template_help_campo")
@NamedQuery(name="GaTemplateHelpCampo.findAll", query="SELECT g FROM GaTemplateHelpCampo g")
public class GaTemplateHelpCampo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GaTemplateHelpCampoPK id;

	@Column(name="long_campo")
	private int longCampo;

	@Column(name="nom_valor")
	private String nomValor;

	@Column(name="num_orden")
	private int numOrden;

	public GaTemplateHelpCampo() {
	}

	public GaTemplateHelpCampoPK getId() {
		return this.id;
	}

	public void setId(GaTemplateHelpCampoPK id) {
		this.id = id;
	}

	public int getLongCampo() {
		return this.longCampo;
	}

	public void setLongCampo(int longCampo) {
		this.longCampo = longCampo;
	}

	public String getNomValor() {
		return this.nomValor;
	}

	public void setNomValor(String nomValor) {
		this.nomValor = nomValor;
	}

	public int getNumOrden() {
		return this.numOrden;
	}

	public void setNumOrden(int numOrden) {
		this.numOrden = numOrden;
	}

}