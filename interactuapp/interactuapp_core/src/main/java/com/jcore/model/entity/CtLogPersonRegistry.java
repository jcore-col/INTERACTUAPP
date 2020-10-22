package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ct_log_person_registry database table.
 * 
 */
@Entity
@Table(name="ct_log_person_registry")
@NamedQuery(name="CtLogPersonRegistry.findAll", query="SELECT c FROM CtLogPersonRegistry c")
public class CtLogPersonRegistry implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CtLogPersonRegistryPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_registry")
	private Date fecRegistry;

	public CtLogPersonRegistry() {
	}

	public CtLogPersonRegistryPK getId() {
		return this.id;
	}

	public void setId(CtLogPersonRegistryPK id) {
		this.id = id;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public Date getFecRegistry() {
		return this.fecRegistry;
	}

	public void setFecRegistry(Date fecRegistry) {
		this.fecRegistry = fecRegistry;
	}

}