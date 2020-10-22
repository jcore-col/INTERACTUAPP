package com.jcore.controller;

import java.io.Serializable;
import javax.servlet.http.HttpSession;

import javax.inject.Inject;
import javax.inject.Named;

import com.jcore.clases_mantenimiento_entity.Ga_Class_UsrProperty;
import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaUsrProperty;
import com.jcore.utils.Message;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Named
@ViewScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Ga_Class_UsrProperty usrPropertyCrud;
	private String user;
	private String claveAcceso;
	private GaUsrProperty propiedadesUsuario;
	
	@PostConstruct
	public void init() {
		
		this.user 		= Ga.VACIO;
		this.claveAcceso  = Ga.VACIO;
		
		this.propiedadesUsuario = new GaUsrProperty();
		
	}
	
	public void valida_usuario() {
		
		if (this.user != null) {
			
			try
			{
				this.propiedadesUsuario = usrPropertyCrud.buscaPorLLaveTabla(this.user);
				
			}
			catch(Exception e)
			{
				Message.registra_Error("No existe usuario");
			}
			
		}
		else
		{
			Message.registra_Error("Diligencie el usuario");
		}
	}
	
	
	public boolean valida_inicio_session() {
		
		if ((this.propiedadesUsuario.getAccesoSinClave().equals(Ga.YES))
			|| (this.propiedadesUsuario.getClaveAcceso().equals(this.claveAcceso)
			    && this.propiedadesUsuario.getCodUsr().equals(this.user))) {
			
			//deberiamos cargar el httpSession hash map con compania y campana de usuario configurados
			return true;
			
		}
		else
		{
			return false;
		}
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}
	
	
	

}
