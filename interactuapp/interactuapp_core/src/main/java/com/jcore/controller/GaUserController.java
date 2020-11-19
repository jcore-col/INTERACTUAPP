package com.jcore.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaUser;
import com.jcore.model.entity.GaUsrProperty;
import com.jcore.service_interface.GaUserCrudService;
import com.jcore.service_interface.GaUsrPropertyCrudService;
import com.jcore.utils.Message;

@Named
@ViewScoped
public class GaUserController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GaUserCrudService  gaUserCrudService;
	@Inject
	private GaUsrPropertyCrudService  gaUsrPropertyCrudService;
	private GaUser gaUser;
	private GaUser gaUserSelec;
	private List<GaUser> gaUsers;
	private String codUsrSearch;
	
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
	public void  insertGaUsrPropertyDefault() {
		
		GaUsrProperty usrPropertyAux = new GaUsrProperty();
		usrPropertyAux.setAccesoSinClave(Ga.NOT);
		usrPropertyAux.setCodUsr(this.gaUser.getCodUsr());
		usrPropertyAux.setCodCampaign(1);
		usrPropertyAux.setCodCompania(1);
		usrPropertyAux.setFecActu(this.gaUser.getFecActu());
		usrPropertyAux.setClaveAcceso(Ga.CLAVE_DEFAULT);
		
		try 
		{
			this.gaUsrPropertyCrudService.insert(usrPropertyAux);
			
		}
		catch (Exception e)
		{
			Message.registra_Error(e.getMessage());
		}
			
	}
	public void  clearUsers() {

		this.gaUsers.clear();
			
	}
	
	public void resetForm() {
		this.gaUser = new GaUser();
		this.gaUserSelec = null;
	}
	@PostConstruct
	public void init() {
		
		this.gaUser = new GaUser();
		this.gaUserSelec = new GaUser();
		this.codUsrSearch = "";
		this.loadUsers();
	}
	
	public void saveUser() {
		
		try
		{
			GaUser userAux;
			
			try 
			{
				userAux = this.gaUserCrudService.buscaPorUsr(this.gaUser.getCodUsr());
			}
			catch(Exception e)
			{
				userAux = null;
			}
			
			
			if(userAux != null) 
			{
				this.gaUserCrudService.update(this.gaUser);
				Message.registra_Info("REGISTRO ACTUALIZADO");
			}
			else
			{
				this.gaUserCrudService.insert(this.gaUser);
				
				this.insertGaUsrPropertyDefault();
				
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
	
	public void selectGaUser(SelectEvent e) {
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
	public void deleteUser() {
		
		try
		{
			if( this.gaUserSelec != null)
			{
				Message.registra_Info("usuario a eliminar"+ this.gaUserSelec.getCodUsr());
				this.gaUser = this.gaUserSelec;
				this.gaUserCrudService.delete(this.gaUser);				
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
	
	public void findUser() {
		
		
		if (this.codUsrSearch != null)
		{
			try
			{
				
				this.gaUserSelec = this.gaUserCrudService.buscaPorUsr(this.codUsrSearch);
				
				
				
				if(this.gaUserSelec != null)
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
	
	
}
