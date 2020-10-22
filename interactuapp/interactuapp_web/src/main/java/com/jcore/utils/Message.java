package com.jcore.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Message {
	
	public static FacesContext getContext()
	{
		return FacesContext.getCurrentInstance();
		
	}
	
	
	public static void registra_Warning(String p_txt_message) {
		addMessage(p_txt_message, FacesMessage.SEVERITY_INFO);
	}
	
	
	public static void registra_Error(String p_txt_message) {
		addMessage(p_txt_message, FacesMessage.SEVERITY_ERROR);
	}
	
	public static void addMessage(String p_txt_mensaje, Severity p_tip_error) {
		FacesMessage mensajeJSF = new FacesMessage();
		mensajeJSF.setSeverity(p_tip_error);
		mensajeJSF.setSummary(p_txt_mensaje);
		getContext().addMessage(null, mensajeJSF);
	}
	

}
