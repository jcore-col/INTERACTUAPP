package com.jcore.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.jcore.model.entity.GaUsrGroupMember;
import com.jcore.service_interface.GaUsrGroupMemberCrudService;
import com.jcore.utils.Message;
@Named
@ViewScoped
public class GaUsrGroupMemberController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GaUsrGroupMemberCrudService  gaUsrGroupMemberCrudService;
	private GaUsrGroupMember gaUsrGroupMember;
	private GaUsrGroupMember gaUsrGroupMemberSelec;
	private List<GaUsrGroupMember> GaUsrsGroupMember;
	private String codUsrSearch;
	
	public void  loadUsers() {

		try 
		{
			this.GaUsrsGroupMember = this.gaUsrGroupMemberCrudService.findAll();
			
		}
		catch (Exception e)
		{
			Message.registra_Error(e.getMessage());
		}
			
	}
	public void  clearUsers() {

		this.GaUsrsGroupMember.clear();
			
	}
	
	public void resetForm() {
		this.gaUsrGroupMember = new GaUsrGroupMember();
		this.gaUsrGroupMemberSelec = null;
	}
	@PostConstruct
	public void init() {
		
		this.gaUsrGroupMember = new GaUsrGroupMember();
		this.gaUsrGroupMemberSelec = new GaUsrGroupMember();
		this.codUsrSearch = "";
		this.loadUsers();
	}
	
	public void saveUser() {
		
		try
		{
			if(this.gaUsrGroupMember.getId().getCodUsr() != null) 
			{
				this.gaUsrGroupMemberCrudService.update(this.gaUsrGroupMember);
				Message.registra_Info("REGISTRO ACTUALIZADO");
			}
			else
			{
				this.gaUsrGroupMemberCrudService.insert(this.gaUsrGroupMember);
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
	
	public void selectGaUsrGroupMember(SelectEvent e) {
		this.gaUsrGroupMemberSelec = (GaUsrGroupMember)e.getObject();
		
	}
	
	public void editUser() {
		
		try
		{
			if( this.gaUsrGroupMemberSelec != null)
			{
				this.gaUsrGroupMember = this.gaUsrGroupMemberSelec;
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
	public void deleteUser() {
		
		try
		{
			if( this.gaUsrGroupMemberSelec != null)
			{
				Message.registra_Info("usuario a eliminar"+ this.gaUsrGroupMemberSelec.getId().getCodUsr());
				this.gaUsrGroupMember = this.gaUsrGroupMemberSelec;
				this.gaUsrGroupMemberCrudService.delete(this.gaUsrGroupMember);				
				this.loadUsers();
				this.resetForm();
				Message.registra_Info("REGISTRO ELIMINADO");
			}
			else
			{
				Message.registra_Error("Porfavor seleccione un registro");
			}
		}
		catch(Exception e)
		{
			Message.registra_Error("al borrar el registro "+e.getMessage() );
		}
		
	}
	
	public void findUser() {
		
		
		if (this.codUsrSearch != null)
		{
			try
			{
				
				this.gaUsrGroupMemberSelec = this.gaUsrGroupMemberCrudService.buscaPorUsr(this.codUsrSearch);
				
				
				
				if(this.gaUsrGroupMemberSelec != null)
				{
					Message.registra_Info(" Usuario encontrado "+ this.codUsrSearch );
					this.editUser();
				}
				else
				{
					Message.registra_Info(" Usuario no encontrado "+ this.codUsrSearch );
					
				}
				
			}
			catch(Exception e)
			{
				Message.registra_Error("No existe usuario"+e.getMessage() );
			}
			
		}
		else
		{
			Message.registra_Info("porfavor digite un codigo de usuario");
		}
		
	}
	public String getCodUsrSearch() {
		return codUsrSearch;
	}
	public void setCodUsrSearch(String codUsrSearch) {
		this.codUsrSearch = codUsrSearch;
	}
	public GaUsrGroupMember getGaUsrGroupMember() {
		return gaUsrGroupMember;
	}
	public void setGaUsrGroupMember(GaUsrGroupMember gaUsrGroupMember) {
		this.gaUsrGroupMember = gaUsrGroupMember;
	}
	public GaUsrGroupMember getGaUsrGroupMemberSelec() {
		return gaUsrGroupMemberSelec;
	}
	public void setGaUsrGroupMemberSelec(GaUsrGroupMember gaUsrGroupMemberSelec) {
		this.gaUsrGroupMemberSelec = gaUsrGroupMemberSelec;
	}
	public List<GaUsrGroupMember> getGaUsrsGroupMember() {
		return GaUsrsGroupMember;
	}
	public void setGaUsrsGroupMember(List<GaUsrGroupMember> gaUsrsGroupMember) {
		GaUsrsGroupMember = gaUsrsGroupMember;
	}
	
	
	
}
