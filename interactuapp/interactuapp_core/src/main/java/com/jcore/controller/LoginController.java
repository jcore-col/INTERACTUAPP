package com.jcore.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.expression.impl.ThisExpressionResolver;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaUser;
import com.jcore.model.entity.GaUsrProperty;
import com.jcore.service_interface.GaUserCrudService;
import com.jcore.service_interface.GaUsrPropertyCrudService;
import com.jcore.utils.Ga_Gbl_Var;
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
	private GaUser gaUser;
	private GaUsrProperty gaUsrProperty;
	
	private String codUsrLogin;
	private String claveAccessoLogin;

	@PostConstruct
	public void init() {

		this.gaUser = new GaUser();
		this.gaUsrProperty = new GaUsrProperty();
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
			Message.registra_Error("No existe usuario");
			this.gaUser = null;
		}
		
		try
		{
			this.gaUsrProperty = this.gaUsrPropertyCrudService.buscaPorUsr(this.gaUser.getCodUsr());
			
		}
		catch(Exception e)
		{
			Message.registra_Error("No existe propiedades para el usuario usuario");
			this.gaUsrProperty = null;
		}
		
		if (this.gaUser != null && this.gaUsrProperty != null)//propiedades minimas inicio de sesion correcta
		{
			if (((this.claveAccessoLogin.equals(this.gaUsrProperty.getClaveAcceso()))||(this.gaUsrProperty.getAccesoSinClave().equals(Ga.YES)) && this.gaUser.getEstado().equals(Ga.USUARIO_ACTIVO)))
			{
				
				GlobalSession.asignaGlobal("cod_usr", this.gaUser.getCodUsr());
				GlobalSession.asignaGlobal("cod_compania", this.gaUsrProperty.getCodCompania());
				GlobalSession.asignaGlobal("cod_campaing", this.gaUsrProperty.getCodCampaign());
				
				return "action_login_ok";
			}
			else
			{
				Message.registra_Info("Contrasena invalida");
				
				return null;
			}
		}
		else
		{
			Message.registra_Info("Debe ingresar credenciales");
			return  null;
		}
	}

	public String getCodUsrLogin() {
		return codUsrLogin;
	}

	public void setCodUsrLogin(String codUsrLogin) {
		this.codUsrLogin = codUsrLogin;
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
		return "action_logout";
	}

	
}
