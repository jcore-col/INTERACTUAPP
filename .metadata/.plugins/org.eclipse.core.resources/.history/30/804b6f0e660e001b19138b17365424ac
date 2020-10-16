package com.jcore.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ga_permission database table.
 * 
 */
@Entity
@Table(name="ga_permission")
@NamedQuery(name="GaPermission.findAll", query="SELECT g FROM GaPermission g")
public class GaPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GaPermissionPK id;

	@Column(name="delete_permission")
	private String deletePermission;

	@Column(name="execute_permission")
	private String executePermission;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_actu")
	private Date fecActu;

	@Column(name="insert_permission")
	private String insertPermission;

	@Column(name="nom_program")
	private String nomProgram;

	@Column(name="nom_rol")
	private String nomRol;

	@Column(name="read_permission")
	private String readPermission;

	@Column(name="update_permission")
	private String updatePermission;

	public GaPermission() {
	}

	public GaPermissionPK getId() {
		return this.id;
	}

	public void setId(GaPermissionPK id) {
		this.id = id;
	}

	public String getDeletePermission() {
		return this.deletePermission;
	}

	public void setDeletePermission(String deletePermission) {
		this.deletePermission = deletePermission;
	}

	public String getExecutePermission() {
		return this.executePermission;
	}

	public void setExecutePermission(String executePermission) {
		this.executePermission = executePermission;
	}

	public Date getFecActu() {
		return this.fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getInsertPermission() {
		return this.insertPermission;
	}

	public void setInsertPermission(String insertPermission) {
		this.insertPermission = insertPermission;
	}

	public String getNomProgram() {
		return this.nomProgram;
	}

	public void setNomProgram(String nomProgram) {
		this.nomProgram = nomProgram;
	}

	public String getNomRol() {
		return this.nomRol;
	}

	public void setNomRol(String nomRol) {
		this.nomRol = nomRol;
	}

	public String getReadPermission() {
		return this.readPermission;
	}

	public void setReadPermission(String readPermission) {
		this.readPermission = readPermission;
	}

	public String getUpdatePermission() {
		return this.updatePermission;
	}

	public void setUpdatePermission(String updatePermission) {
		this.updatePermission = updatePermission;
	}

}