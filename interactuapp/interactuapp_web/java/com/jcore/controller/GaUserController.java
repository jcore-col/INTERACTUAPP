package com.jcore.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.jcore.model.entity.GaUser;
import com.jcore.service_interface.GaUserCrudService;
import com.jcore.utils.Message;

@Named
@ViewScoped
public class GaUserController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GaUserCrudService  gaUserCrudService;
	private GaUser gaUser;
	private GaUser gaUserSelec;
	private List<GaUser> gaUsers;
	
	public void  loadUsers() {

		try 
		{
			this.gaUsers = this.gaUserCrudService.findAll();
			
		}
		catch (Exception e)
		{
			Message.registra_Error(e.getMessage());
		}
			
	}
	
	public void resetForm() {
		this.gaUser = new GaUser();
		this.gaUserSelec = null;
	}
	@PostConstruct
	public void init() {
		
		this.gaUser = new GaUser();
		this.gaUserSelec = new GaUser();
		this.loadUsers();
	}
	
	public void saveUser() {
		
		try
		{
			if(this.gaUser.getCodUsr() != null) 
			{
				this.gaUserCrudService.update(this.gaUser);
				Message.registra_Info("REGISTRO ACTUALIZADO");
			}
			else
			{
				this.gaUserCrudService.insert(this.gaUser);
				Message.registra_Info("REGISTRO AGREGADO");
			}
			this.loadUsers();
			this.resetForm();
		}
		catch(Exception e)
		{
			Message.registra_Error(e.getMessage());
		}
		
	}
	
	public void selectUser(SelectEvent e) {
		this.gaUserSelec = (GaUser)e.getObject();
	}
	
	public void editUser() {
		
		try
		{
			if( this.gaUserSelec != null)
			{
				this.gaUser = this.gaUserSelec;
			}
			else
			{
				Message.registra_Error("Porfavor seleccione un registro");
			}
		}
		catch(Exception e)
		{
			Message.registra_Error("al actualizar el registro "+e.getMessage() );
		}
	}
	
	public GaUser getGaUser() {
		return gaUser;
	}

	public void setGaUser(GaUser gaUser) {
		this.gaUser = gaUser;
	}

	public GaUser getGaUserSelec() {
		return gaUserSelec;
	}

	public void setGaUserSelec(GaUser gaUserSelec) {
		this.gaUserSelec = gaUserSelec;
	}

	public List<GaUser> getGaUsers() {
		return gaUsers;
	}

	public void setGaUsers(List<GaUser> gaUsers) {
		this.gaUsers = gaUsers;
	}
	
	
}
