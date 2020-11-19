package com.jcore.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.jcore.model.entity.GaAccessControl;
import com.jcore.model.entity.GaRole;
import com.jcore.model.entity.GaUser;
import com.jcore.service_interface.GaAccessControlCrudService;
import com.jcore.service_interface.GaRoleCrudService;
import com.jcore.service_interface.GaUserCrudService;
import com.jcore.utils.Message;

@Named
@ViewScoped
public class GaAccessControlController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GaAccessControlCrudService  gaAccessControlCrudService;
	
	@Inject
	private GaRoleCrudService  gaRoleCrudService;
	@Inject
	private GaUserCrudService  gaUserCrudService;
	
	private GaAccessControl gaAccessControl;
	private GaAccessControl gaAccessControlSelec;
	private List<GaAccessControl> gaAccessControlByUsr;
	private String codUsrSearch;
	
	public void  clearUsers() {

		this.gaAccessControlByUsr.clear();
			
	}
	
	public void resetForm() {
		this.gaAccessControl = new GaAccessControl();
		this.gaAccessControlSelec = null;
	}
	@PostConstruct
	public void init() {
		
		this.gaAccessControl = new GaAccessControl();
		this.gaAccessControlSelec = new GaAccessControl();
		this.codUsrSearch = "";
	}
	
	public void saveUser() {
		
		try
		{
			
			if(this.gaAccessControl.getId().getCodUsr() != null) 
			{
				GaRole auxRole = new GaRole();
				auxRole.setCodRol(this.gaAccessControl.getId().getCodRol());
				auxRole = this.gaRoleCrudService.findById(auxRole);
				//
				this.gaAccessControl.setNomRol(auxRole.getNomRol());
				auxRole = null;
				GaUser auxUser = this.gaUserCrudService.buscaPorUsr(this.gaAccessControl.getId().getCodUsr());
				this.gaAccessControl.setNomUsr(auxUser.getNomUsr());
				auxUser = null;
				this.gaAccessControlCrudService.update(this.gaAccessControl);
				Message.registra_Info("REGISTRO ACTUALIZADO");
			}
			else
			{
				this.gaAccessControlCrudService.insert(this.gaAccessControl);
				Message.registra_Info("REGISTRO AGREGADO");
			}
			
			this.resetForm();
		}
		catch(Exception e)
		{
			Message.registra_Error(e.getMessage());
		}
		
	}
	
	public void selectGaAccessControl(SelectEvent e) {
		this.gaAccessControlSelec = (GaAccessControl)e.getObject();
		
	}
	
	public void editUser() {
		
		try
		{
			if( this.gaAccessControlSelec != null)
			{
				this.gaAccessControl = this.gaAccessControlSelec;
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
			if( this.gaAccessControlSelec != null)
			{
				Message.registra_Info("usuario a eliminar"+ this.gaAccessControlSelec.getId().getCodUsr());
				this.gaAccessControl = this.gaAccessControlSelec;
				this.gaAccessControlCrudService.delete(this.gaAccessControl);
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
	
	//CARGA LOS ROLES POR USUARIO EN EL DATATABLE
	public void findUser() {
		
		
		if (this.codUsrSearch != null)
		{
			try
			{
				
				this.gaAccessControlByUsr = this.gaAccessControlCrudService.buscaPorUsr(this.codUsrSearch);
				
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

	public GaAccessControl getGaAccessControl() {
		return gaAccessControl;
	}

	public void setGaAccessControl(GaAccessControl gaAccessControl) {
		this.gaAccessControl = gaAccessControl;
	}

	public GaAccessControl getGaAccessControlSelec() {
		return gaAccessControlSelec;
	}

	public void setGaAccessControlSelec(GaAccessControl gaAccessControlSelec) {
		this.gaAccessControlSelec = gaAccessControlSelec;
	}

	public List<GaAccessControl> getGaAccessControlByUsr() {
		return gaAccessControlByUsr;
	}

	public void setGaAccessControlByUsr(List<GaAccessControl> gaAccessControlByUsr) {
		this.gaAccessControlByUsr = gaAccessControlByUsr;
	}

	public String getCodUsrSearch() {
		return codUsrSearch;
	}

	public void setCodUsrSearch(String codUsrSearch) {
		this.codUsrSearch = codUsrSearch;
	}
	
	
}
