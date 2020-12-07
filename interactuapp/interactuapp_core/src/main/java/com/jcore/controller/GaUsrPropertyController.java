package com.jcore.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.jcore.model.entity.GaUsrProperty;
import com.jcore.service_interface.GaUsrPropertyCrudService;
import com.jcore.utils.Message;

@Named
@ViewScoped
public class GaUsrPropertyController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GaUsrPropertyCrudService  gaUsrPropertyCrudService;
	private GaUsrProperty gaUsrProperty;
	private GaUsrProperty gaUsrPropertySelec;
	private List<GaUsrProperty> gaUsrsProperty;
	private String codUsrSearch;
	
	public void  loadUsers() {

		try 
		{
			this.gaUsrsProperty = this.gaUsrPropertyCrudService.findAll();
			
		}
		catch (Exception e)
		{
			Message.registra_Error(e.getMessage());
		}
			
	}
	public void  clearUsers() {

		this.gaUsrsProperty.clear();
			
	}
	
	public void resetForm() {
		this.gaUsrProperty = new GaUsrProperty();
		this.gaUsrPropertySelec = null;
	}
	@PostConstruct
	public void init() {
		
		this.gaUsrProperty = new GaUsrProperty();
		this.gaUsrPropertySelec = new GaUsrProperty();
		this.codUsrSearch = "";
		this.loadUsers();
	}
	
	public void saveUser() {
		
		try
		{
			if(this.gaUsrProperty.getCodUsr() != null) 
			{
				this.gaUsrPropertyCrudService.update(this.gaUsrProperty);
				Message.registra_Info("REGISTRO ACTUALIZADO");
			}
			else
			{
				this.gaUsrPropertyCrudService.insert(this.gaUsrProperty);
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
	
	public void selectGaUsrProperty(SelectEvent e) {
		this.gaUsrPropertySelec = (GaUsrProperty)e.getObject();
		
	}
	
	public void editUser() {
		
		try
		{
			if( this.gaUsrPropertySelec != null)
			{
				this.gaUsrProperty = this.gaUsrPropertySelec;
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
			if( this.gaUsrPropertySelec != null)
			{
				Message.registra_Info("usuario a eliminar"+ this.gaUsrPropertySelec.getCodUsr());
				this.gaUsrProperty = this.gaUsrPropertySelec;
				this.gaUsrPropertyCrudService.delete(this.gaUsrProperty);				
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
				
				this.gaUsrPropertySelec = this.gaUsrPropertyCrudService.buscaPorUsr(this.codUsrSearch);
				
				
				
				if(this.gaUsrPropertySelec != null)
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
	public GaUsrProperty getGaUsrProperty() {
		return gaUsrProperty;
	}
	public void setGaUsrProperty(GaUsrProperty gaUsrProperty) {
		this.gaUsrProperty = gaUsrProperty;
	}
	public GaUsrProperty getGaUsrPropertySelec() {
		return gaUsrPropertySelec;
	}
	public void setGaUsrPropertySelec(GaUsrProperty gaUsrPropertySelec) {
		this.gaUsrPropertySelec = gaUsrPropertySelec;
	}
	public List<GaUsrProperty> getGaUsrsProperty() {
		return gaUsrsProperty;
	}
	public void setGaUsrsProperty(List<GaUsrProperty> gaUsrsProperty) {
		this.gaUsrsProperty = gaUsrsProperty;
	}
	
	
}
