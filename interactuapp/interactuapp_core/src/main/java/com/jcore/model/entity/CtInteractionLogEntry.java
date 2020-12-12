package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ct_interaction_log_entry database table.
 * 
 */
@Entity
@Table(name="ct_interaction_log_entry")
@NamedQuery(name="CtInteractionLogEntry.findAll", query="SELECT c FROM CtInteractionLogEntry c")
public class CtInteractionLogEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CtInteractionLogEntryPK id;

	@Column(name="cod_usr")
	private String codUsr;

	@Column(name="cod_usr_reg")
	private String codUsrReg;

	@Column(name="evaluation_entry")
	private int evaluationEntry;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_entry_reg")
	private Date fecEntryReg;

	public CtInteractionLogEntry() {
		this.id = new CtInteractionLogEntryPK();
	}

	public CtInteractionLogEntryPK getId() {
		return this.id;
	}

	public void setId(CtInteractionLogEntryPK id) {
		this.id = id;
	}

	public String getCodUsr() {
		return this.codUsr;
	}

	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}

	public String getCodUsrReg() {
		return this.codUsrReg;
	}

	public void setCodUsrReg(String codUsrReg) {
		this.codUsrReg = codUsrReg;
	}

	public int getEvaluationEntry() {
		return this.evaluationEntry;
	}

	public void setEvaluationEntry(int evaluationEntry) {
		this.evaluationEntry = evaluationEntry;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public Date getFecEntryReg() {
		return this.fecEntryReg;
	}

	public void setFecEntryReg(Date fecEntryReg) {
		this.fecEntryReg = fecEntryReg;
	}

}