package com.jcore.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaAccessControl;
import com.jcore.model.entity.GaUser;
import com.jcore.model.entity.GaUsrProperty;
import com.jcore.service_interface.GaAccessControlCrudService;
import com.jcore.service_interface.GaUserCrudService;
import com.jcore.service_interface.GaUsrPropertyCrudService;
import com.jcore.utils.GlobalSession;
import com.jcore.utils.Message;

@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GaUserCrudService gaUserCrudService;
	@Inject
	private GaUsrPropertyCrudService gaUsrPropertyCrudService;
	@Inject
	private GaAccessControlCrudService gAccessControlService;
	private List<GaAccessControl> gaAccessControl;
	private GaUser gaUser;
	private GaUsrProperty gaUsrProperty;
	
	private String claveAccessoLogin;
	
	private String navigationCase;

	@PostConstruct
	public void init() {

		this.gaUser = new GaUser();
		this.gaUsrProperty = new GaUsrProperty();
		this.navigationCase= "action_login_ok_";
	}

	public GaUser getGaUser() {
		return gaUser;
	}

	public void setGaUser(GaUser gaUser) {
		this.gaUser = gaUser;
	}

	public GaUsrProperty getGaUsrProperty() {
		return gaUsrProperty;
	}

	public void setGaUsrProperty(GaUsrProperty gaUsrProperty) {
		this.gaUsrProperty = gaUsrProperty;
	}

	public String login() {
		
		Message.registra_Info("usuario digitado"+ this.gaUser.getCodUsr());
		try
		{
			this.gaUser = this.gaUserCrudService.buscaPorUsr(this.gaUser.getCodUsr());
			
		}
		catch(Exception e)
		{
			Message.registra_Error("No existe usuario "+this.gaUser.getCodUsr()+" "+ e.getMessage());
			this.gaUser = null;
		}
		
		try
		{
			this.gaUsrProperty = this.gaUsrPropertyCrudService.buscaPorUsr(this.gaUser.getCodUsr());
			
		}
		catch(Exception e)
		{
			Message.registra_Error("No existe propiedades para el usuario "+this.gaUser.getCodUsr()+" "+ e.getMessage());
			this.gaUsrProperty = null;
		}
		
		if (this.gaUser != null && this.gaUsrProperty != null)//propiedades minimas inicio de sesion correcta
		{
			if (((this.claveAccessoLogin.equals(this.gaUsrProperty.getClaveAcceso()))||(this.gaUsrProperty.getAccesoSinClave().equals(Ga.YES)) && this.gaUser.getEstado().equals(Ga.USUARIO_ACTIVO)))
			{
				
				GlobalSession.asignaGlobal("cod_usr", this.gaUser.getCodUsr());
				GlobalSession.asignaGlobal("cod_compania", this.gaUsrProperty.getCodCompania());
				GlobalSession.asignaGlobal("cod_campaing", this.gaUsrProperty.getCodCampaign());
				
				try
				{
					this.gaAccessControl = this.gAccessControlService.buscaPorUsr(this.gaUser.getCodUsr());
					
					
					if (this.gaAccessControl.size() > 1)
					{
						this.navigationCase = this.navigationCase + "1";
						GlobalSession.asignaGlobal("rol_usr", "ADMIN");
					}
					else
					{
						if (this.gaAccessControl.size() == 1)
						{
							for (GaAccessControl e : this.gaAccessControl)
							{
								this.navigationCase = this.navigationCase + e.getId().getCodRol();
								
								if (e.getId().getCodRol() == "1")
								{
									GlobalSession.asignaGlobal("rol_usr", "ADMIN");
								}
								else
								{
									GlobalSession.asignaGlobal("rol_usr", "LIDER");
								}
							}
						}
						
					}
					
					
					GlobalSession.asignaGlobal("listAccessControlUsr", this.gaAccessControl);
				
				}
				catch(Exception e)
				{
					Message.registra_Error("El usuario"+this.gaUser.getCodUsr()+" No tiene permisos configurados");
					
				}
				
				
				return this.navigationCase;
			}
			else
			{
				Message.registra_Info("Contrasena invalida");
				resetForm();
				return "action_login_logout";
			}
		}
		else
		{
			Message.registra_Info("Debe ingresar credenciales");
			resetForm();
			return  "action_login_logout";
		}
	}

	public void resetForm()
	{
		this.gaUser = new GaUser();
		this.gaUsrProperty = new GaUsrProperty();
		this.claveAccessoLogin = "";
		this.navigationCase = "action_login_ok_";
	}

	public String getClaveAccessoLogin() {
		return claveAccessoLogin;
	}

	public void setClaveAccessoLogin(String claveAccessoLogin) {
		this.claveAccessoLogin = claveAccessoLogin;
	}
	
	public String logout() {
		HttpSession session = GlobalSession.getSession();
		session.invalidate();
		return "action_login_logout";
	}

	
}
